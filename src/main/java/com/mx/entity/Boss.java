package com.mx.entity;

/**
 * @author MX
 */
public class Boss {
    private Integer bossId;
    private String bossName;
    private String bossPassword;

    public Boss() {
    }

    public Integer getBossId() {
        return bossId;
    }

    public void setBossId(Integer bossId) {
        this.bossId = bossId;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public String getBossPassword() {
        return bossPassword;
    }

    public void setBossPassword(String bossPassword) {
        this.bossPassword = bossPassword;
    }
}
