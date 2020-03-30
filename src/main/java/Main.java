import entities.asset.Client;
import entities.asset.Matter;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        // Example 1 - Create Restricted client policy, with Staffing
//        Client client = AssetService.createClient(
//                "TEST01",
//                "TEST01",
//                Client.ClientSecurityPolicy.CLIENT_RESTRICTED,
//                Arrays.asList("user15", "user14"),
//                Collections.emptyList()
//        );
//        System.out.println("Successfully created client with sid:" + client.getSid());


        // Example 2 - Create Restricted matter policy, with Staffing
        // Given client exists (see example 1)
        // Create matter
//        Matter matter = AssetService.createMatter(
//                "TEST01",
//                "TEST01",
//                Matter.MatterSecurityPolicy.RESTRICTED,
//                client,
//                Arrays.asList("user15", "user14"),
//                Collections.emptyList()
//        );
//        System.out.println("Successfully created client with sid:" + client.getSid());


        // Example 3 - Create Open client policy, add conflicted users
        Client client2 = AssetService.createClient(
                "TEST02",
                "TEST02",
                Client.ClientSecurityPolicy.MIXED,
                Collections.emptyList(),
                Collections.emptyList()
        );
        System.out.println("Successfully created client with sid:" + client2.getSid());
        // Add conflicts
        AssetService.addConflicts(client2, Arrays.asList("user14", "user15"));

        // Example 4 - Create Open matter policy, add conflicted users
        // Given client exists (see example 3)
        // Create matter
        Matter matter2 = AssetService.createMatter(
                "TEST02",
                "TEST02",
                Matter.MatterSecurityPolicy.RESTRICTED,
                client2,
                Arrays.asList("user15", "user14"),
                Collections.emptyList()
        );
        System.out.println("Successfully created client with sid:" + matter2.getSid());
        // Add conflicts
        AssetService.addConflicts(matter2, Arrays.asList("user14", "user15"));

    }
}
