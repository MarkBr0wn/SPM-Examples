package entities.opposingsets;

import java.util.List;

public class OpposingSetSide {
    private Long sid;
    private Long lockCount;
    private Boolean complexStaffing = false;
    private List<OpposingSetSideAsset> assets;

    public Boolean getComplexStaffing() {
        return complexStaffing;
    }

    public void setComplexStaffing(Boolean complexStaffing) {
        this.complexStaffing = complexStaffing;
    }

    public List<OpposingSetSideAsset> getAssets() {
        return assets;
    }

    public void setAssets(List<OpposingSetSideAsset> assets) {
        this.assets = assets;
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
