import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

public class AuthenticationManager {

    private static final String ACCESS_TOKEN = "access_token";

    // Holder for the response info for each session
    public class AuthResponse {
        private boolean response;
        private JsonNode spmJWT;

        AuthResponse(JsonNode jsonNode, boolean response) {
            this.response = response;
            this.spmJWT = jsonNode;
        }

        public boolean isResponse() {
            return response;
        }

        public String getToken() {
            return spmJWT.findValue(ACCESS_TOKEN).asText();
        }
    }

    public AuthResponse authenticate(RestTemplate rest, String url, String username, String password) {
        if (username == null || password == null || url == null) {
            System.exit(1);
        }

        HttpHeaders headers = new HttpHeaders();
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
        headers.add("Authorization", basicAuth);
        HttpEntity<String> request = new HttpEntity<>("", headers);

        ResponseEntity<JsonNode> curJWT = rest.exchange("{wallServerUrl}" + Constants.AUTHENTICATE, HttpMethod.GET, request, JsonNode.class, url);
        return new AuthResponse(curJWT.getBody(), curJWT.getBody().findValue(ACCESS_TOKEN) != null);
    }
}
