import com.google.gson.Gson;
import entities.ConflictedUser;
import entities.asset.Asset;
import entities.asset.Client;
import entities.asset.Matter;
import entities.opposingsets.OpposingSet;
import entities.opposingsets.OpposingSetSide;
import entities.opposingsets.OpposingSetSideAsset;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

        return helper.postAndGet(Constants.ASSET_POST, new Gson().toJson(client), Client.class);
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

        return helper.postAndGet(Constants.ASSET_POST, new Gson().toJson(matter), Matter.class);
    }

    public static ResponseEntity<Object> addConflicts(Asset asset,
                                                      List<String> users) {

        RestHelper helper = new RestHelper();
        UserService userService = new UserService();

        List<ConflictedUser> conflictedUsers = userService.resolveUsers(users).stream()
                .map(u -> new ConflictedUser(u, asset))
                .collect(Collectors.toList());

        return helper.post(Constants.CONFLICTS_POST, new Gson().toJson(conflictedUsers));
    }

    public static ResponseEntity<Object> opposeAssets(String displayId,
                                                      String displayName,
                                                      Asset... assets) {

        RestHelper helper = new RestHelper();

        OpposingSet opposingSet = new OpposingSet();
        opposingSet.setDisplayId(displayId);
        opposingSet.setDisplayName(displayName);

        List<OpposingSetSide> sides = new ArrayList<>();
        for (Asset asset : assets) {
            OpposingSetSide side = new OpposingSetSide();
            OpposingSetSideAsset opposingSetSideAsset = new OpposingSetSideAsset(asset);
            side.setAssets(Collections.singletonList(opposingSetSideAsset));
            sides.add(side);
        }

        opposingSet.setSides(sides);

        return helper.post(Constants.OTS_POST, new Gson().toJson(opposingSet));
    }
}
