package entities.opposingsets;

import java.util.List;

public class OpposingSet {
    private Long sid;
    private Long lockCount;
    private String displayId;
    private String displayName;
    List<OpposingSetSide> sides;

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

    public String getDisplayId() {
        return displayId;
    }

    public void setDisplayId(String displayId) {
        this.displayId = displayId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<OpposingSetSide> getSides() {
        return sides;
    }

    public void setSides(List<OpposingSetSide> sides) {
        this.sides = sides;
    }
}
