import com.google.gson.Gson;
import entities.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class RestHelper {

    private static final String ACCESS_TOKEN = "access_token";

    String activeToken;
    RestTemplate restTemplate;

    public String currentLogin() {
        if (activeToken == null) {
            activeToken = authenticate("SPMAdmin", "password"); // TODO constants
        }
        return activeToken;
    }

    public RestTemplate getRestTemplate() {
        if (restTemplate == null) {
            restTemplate = new RestTemplate();
            restTemplate.setErrorHandler(new DetailedResponseErrorHandler());
        }
        return restTemplate;
    }

    public String authenticate(String username, String password) {
        AuthenticationManager authenticationManager = new AuthenticationManager();
        RestTemplate restTemplate = new RestTemplate();
        AuthenticationManager.AuthResponse response = authenticationManager.authenticate(restTemplate, Constants.BASE_URL, username, password);
        return response.getToken();
    }

    public <T> ResponseEntity<T> get(String uri, Class<T> clazz) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + currentLogin());
        headers.add("Content-Type", Constants.JSON_TYPE);
        HttpEntity<?> httpEntity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = getRestTemplate().exchange(uri, HttpMethod.GET, httpEntity, String.class);

        T content = new Gson().fromJson(response.getBody(), clazz);
        return new ResponseEntity<>(content, response.getHeaders(), response.getStatusCode());
    }

    public List<User> resolveUsers(String uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + currentLogin());
        headers.add("Content-Type", Constants.JSON_TYPE);
        HttpEntity<?> httpEntity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = getRestTemplate().exchange(uri, HttpMethod.GET, httpEntity, String.class);

        List<Map> users = (List<Map>)new Gson().fromJson(response.getBody(), Map.class).getOrDefault("content", Collections.emptyList());
        return users.stream()
                .map( m -> m.getOrDefault("sid", null) )
                .filter(Objects::nonNull)
                .map(n -> ((Number)n).longValue())
                .map(User::new)
                .collect(Collectors.toList());
    }

    public ResponseEntity<Object> post(String uri, String content) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + currentLogin());
        headers.add("Content-Type", Constants.JSON_TYPE);
        HttpEntity<?> httpEntity = new HttpEntity<Object>(content, headers);
        ResponseEntity<String> response = getRestTemplate().exchange(uri, HttpMethod.POST, httpEntity, String.class);
        return new ResponseEntity<>(content, response.getHeaders(), response.getStatusCode());
    }

    public <T> T postAndGet(String uri, String content, Class<T> clazz) {

        ResponseEntity<Object> response = post(uri, content);

        if(response.getStatusCode() != HttpStatus.CREATED) {
            System.out.println("Failed to create Object, status code was: " + response.getStatusCode());
            System.exit(1);
        }

        HttpHeaders headers = response.getHeaders();
        URI location = headers.getLocation();
        return get(location.toString(), clazz).getBody();
    }
}
