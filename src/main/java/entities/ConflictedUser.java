package entities;

import entities.asset.Asset;

public class ConflictedUser {

    public ConflictedUser(User user, Asset asset) {
        this.trustee = user;
        this.asset = asset;
    }

    private User trustee;
    private Asset asset;


    public User getTrustee() {
        return trustee;
    }

    public void setTrustee(User trustee) {
        this.trustee = trustee;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
