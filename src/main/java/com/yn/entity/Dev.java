package com.yn.entity;

public class Dev extends Base{
    private String devName;

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName == null ? null : devName.trim();
    }
}