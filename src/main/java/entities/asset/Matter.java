package entities.asset;

import com.google.gson.annotations.SerializedName;

public class Matter extends Asset {

    public enum MatterSecurityPolicy {
        OPEN,
        RESTRICTED,
        INHERITED   // Secured By Client
    }

    @SerializedName(value = "@type", alternate = "type")
    private String type = Asset.MATTER_TYPE;

    private MatterSecurityPolicy securityType;
    private Client client;

    public void setSecurityType(MatterSecurityPolicy securityType) {
        this.securityType = securityType;
    }

    public MatterSecurityPolicy getSecurityType() {
        return securityType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
