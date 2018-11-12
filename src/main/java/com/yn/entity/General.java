package com.yn.entity;

public class General extends Base{
    private String projectName;

    private Integer enableRedun;

    private String ip1;

    private String ip2;

    private String ip3;

    private Integer modify;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Integer getEnableRedun() {
        return enableRedun;
    }

    public void setEnableRedun(Integer enableRedun) {
        this.enableRedun = enableRedun;
    }

    public String getIp1() {
        return ip1;
    }

    public void setIp1(String ip1) {
        this.ip1 = ip1 == null ? null : ip1.trim();
    }

    public String getIp2() {
        return ip2;
    }

    public void setIp2(String ip2) {
        this.ip2 = ip2 == null ? null : ip2.trim();
    }

    public String getIp3() {
        return ip3;
    }

    public void setIp3(String ip3) {
        this.ip3 = ip3 == null ? null : ip3.trim();
    }

    public Integer getModify() {
        return modify;
    }

    public void setModify(Integer modify) {
        this.modify = modify;
    }
}