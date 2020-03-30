import entities.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    /**
     * Given a list of 'name' fields for users, resolve them out using the REST API to get their associated sid.
     * @param userNames
     * @return
     */
    public List<User> resolveUsers(List<String> userNames) {

        if (userNames.isEmpty()) {
            return Collections.emptyList();
        }

        RestHelper helper = new RestHelper();

        String uri = Constants.TRUSTEE_FETCH +
                "?" +
                userNames.stream().map(name -> "name=" + name)
                .collect(Collectors.joining("&"));

        return helper.resolveUsers(uri);
    }
}
