package com.yn.entity;

public class CAbcip extends Base{
    private String name;

    private Integer weight;

    private String mainIp;

    private String backIp;

    private Integer port;

    private Integer clctInterval;

    private Integer clctTimeout;

    private Integer cmdTimeout;

    private Integer packageLen;

    private String route;

    private Integer cmdCacheSize;

    private Integer active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getMainIp() {
        return mainIp;
    }

    public void setMainIp(String mainIp) {
        this.mainIp = mainIp == null ? null : mainIp.trim();
    }

    public String getBackIp() {
        return backIp;
    }

    public void setBackIp(String backIp) {
        this.backIp = backIp == null ? null : backIp.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getClctInterval() {
        return clctInterval;
    }

    public void setClctInterval(Integer clctInterval) {
        this.clctInterval = clctInterval;
    }

    public Integer getClctTimeout() {
        return clctTimeout;
    }

    public void setClctTimeout(Integer clctTimeout) {
        this.clctTimeout = clctTimeout;
    }

    public Integer getCmdTimeout() {
        return cmdTimeout;
    }

    public void setCmdTimeout(Integer cmdTimeout) {
        this.cmdTimeout = cmdTimeout;
    }

    public Integer getPackageLen() {
        return packageLen;
    }

    public void setPackageLen(Integer packageLen) {
        this.packageLen = packageLen;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route == null ? null : route.trim();
    }

    public Integer getCmdCacheSize() {
        return cmdCacheSize;
    }

    public void setCmdCacheSize(Integer cmdCacheSize) {
        this.cmdCacheSize = cmdCacheSize;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}