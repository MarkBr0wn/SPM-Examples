package entities.asset;

import com.google.gson.annotations.SerializedName;

public class Client extends Asset {

    public enum ClientSecurityPolicy {
        MIXED,              // Open
        CLIENT_RESTRICTED,  // Restricted (Locked)
        MATTER_RESTRICTED   // Restricted (Open Up)
    }

    @SerializedName(value = "@type", alternate = "type")
    private String type = Asset.CLIENT_TYPE;

    private ClientSecurityPolicy securityType;

    public void setSecurityType(ClientSecurityPolicy securityType) {
        this.securityType = securityType;
    }

    public ClientSecurityPolicy getSecurityType() {
        return securityType;
    }
}
