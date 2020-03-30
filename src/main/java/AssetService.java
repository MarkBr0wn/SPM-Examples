import com.google.gson.Gson;
import entities.asset.Client;
import entities.asset.Matter;

import java.util.List;

public class AssetService {

    public static Client createClient(String displayId,
                                      String displayName,
                                      Client.ClientSecurityPolicy securityPolicy,
                                      List<String> teamMembers,
                                      List<String> basicTeamMembers) {

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

    public static Matter createMatter(String displayId,
                                      String displayName,
                                      Matter.MatterSecurityPolicy securityPolicy,
                                      Client client,
                                      List<String> teamMembers,
                                      List<String> basicTeamMembers) {

        RestHelper helper = new RestHelper();
        UserService userService = new UserService();

        Matter matter = new Matter();
        matter.setDisplayId(displayId);
        matter.setDisplayName(displayName);
        matter.setSecurityType(securityPolicy);
        matter.setClient(client);
        matter.setAssetTeam(userService.resolveUsers(teamMembers));
        matter.setAdditionalUsers(userService.resolveUsers(basicTeamMembers));

        return helper.postAndGet(Endpoints.ASSET_POST, new Gson().toJson(matter), Matter.class);
    }
}
