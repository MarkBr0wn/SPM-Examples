import com.google.gson.Gson;
import entities.asset.Client;

import java.util.List;

public class AssetService {

    public static Client createClient(String displayId, String displayName, Client.ClientSecurityPolicy securityPolicy, List<String> teamMembers, List<String> basicTeamMembers) {

        RestHelper helper = new RestHelper();
        UserService userService = new UserService();

        Client client = new Client();
        client.setDisplayId(displayId);
        client.setDisplayName(displayName);
        client.setSecurityType(securityPolicy);
        client.setAssetTeam(userService.resolveUsers(teamMembers));
        client.setAdditionalUsers(userService.resolveUsers(basicTeamMembers));

        return helper.postAndGet(Endpoints.ASSET_POST, new Gson().toJson(client), Client.class);
    }
}
