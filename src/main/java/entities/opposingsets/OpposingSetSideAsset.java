package entities.opposingsets;

import entities.asset.Asset;

public class OpposingSetSideAsset {
    private Long sid;
    private Long lockCount;
    private Asset asset;

    public OpposingSetSideAsset(Asset asset) {
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

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
