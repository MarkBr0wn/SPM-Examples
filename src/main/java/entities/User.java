package entities;

import com.google.gson.annotations.SerializedName;

public class User {

    public User(Long sid) {
        this.sid = sid;
        this.lockCount = -1L;
    }

    @SerializedName(value = "@type", alternate = "type")
    private String type = "user";

    private Long sid;
    private Long lockCount;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
