import entities.asset.Client;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        // Example 1 - Create Restricted client policy, with Staffing
        Client client = AssetService.createClient(
                "TEST01",
                "TEST01",
                Client.ClientSecurityPolicy.CLIENT_RESTRICTED,
                Arrays.asList("user15", "user14"),
                Collections.emptyList()
        );
        System.out.println("Successfully created client with sid:" + client.getSid());

    }
}
