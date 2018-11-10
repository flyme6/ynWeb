package com.yn.entity;

public class FModbusRtu extends Base{
    private String name;

    private Integer port;

    private Integer cmdTimeout;

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

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getCmdTimeout() {
        return cmdTimeout;
    }

    public void setCmdTimeout(Integer cmdTimeout) {
        this.cmdTimeout = cmdTimeout;
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