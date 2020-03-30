package entities;

import entities.asset.Asset;

public class ConflictedUser {

    public ConflictedUser(User user, Asset asset) {
        this.trustee = user;
        this.asset = asset;
    }

    private Long sid;
    private Long lockCount;
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

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getLockCount() {
        return lockCount;
    }

    public void setLockCount(Long lockCount) {
        this.lockCount = lockCount;
    }
}
