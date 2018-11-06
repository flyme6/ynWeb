package com.yn.entity;

public class CModbusTcpRtu {
    private String name;

    private Integer weight;

    private String mainIp;

    private String backIp;

    private Integer port;

    private Integer clctInterval;

    private Integer clctTimeout;

    private Integer cmdTimeout;

    private Integer faultCount;

    private Integer packageLen;

    private Integer allowEmptyAddr;

    private String byteOrder16;

    private String byteOrder32;

    private String byteOrder64;

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

    public Integer getFaultCount() {
        return faultCount;
    }

    public void setFaultCount(Integer faultCount) {
        this.faultCount = faultCount;
    }

    public Integer getPackageLen() {
        return packageLen;
    }

    public void setPackageLen(Integer packageLen) {
        this.packageLen = packageLen;
    }

    public Integer getAllowEmptyAddr() {
        return allowEmptyAddr;
    }

    public void setAllowEmptyAddr(Integer allowEmptyAddr) {
        this.allowEmptyAddr = allowEmptyAddr;
    }

    public String getByteOrder16() {
        return byteOrder16;
    }

    public void setByteOrder16(String byteOrder16) {
        this.byteOrder16 = byteOrder16 == null ? null : byteOrder16.trim();
    }

    public String getByteOrder32() {
        return byteOrder32;
    }

    public void setByteOrder32(String byteOrder32) {
        this.byteOrder32 = byteOrder32 == null ? null : byteOrder32.trim();
    }

    public String getByteOrder64() {
        return byteOrder64;
    }

    public void setByteOrder64(String byteOrder64) {
        this.byteOrder64 = byteOrder64 == null ? null : byteOrder64.trim();
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