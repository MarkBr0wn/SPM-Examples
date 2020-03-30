package entities.asset;

import entities.User;

import java.util.List;

public class Asset {

    public static String CLIENT_TYPE = "client";
    public static String MATTER_TYPE = "matter";

    private Long sid;
    private Long lockCount;
    private String displayId;
    private String displayName;
    private Boolean breakInheritance = false;
    private Boolean visible = true;
    private String accessRequestType = "NONE";
    private List<User> assetTeam;
    private List<User> additionalUsers;

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

    public List<User> getAssetTeam() {
        return assetTeam;
    }

    public void setAssetTeam(List<User> assetTeam) {
        this.assetTeam = assetTeam;
    }

    public List<User> getAdditionalUsers() {
        return additionalUsers;
    }

    public void setAdditionalUsers(List<User> additionalUsers) {
        this.additionalUsers = additionalUsers;
    }

    public Boolean getBreakInheritance() {
        return breakInheritance;
    }

    public void setBreakInheritance(Boolean breakInheritance) {
        this.breakInheritance = breakInheritance;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getAccessRequestType() {
        return accessRequestType;
    }

    public void setAccessRequestType(String accessRequestType) {
        this.accessRequestType = accessRequestType;
    }
}
