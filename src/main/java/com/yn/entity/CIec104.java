package com.yn.entity;

public class CIec104 extends Base{
    private String name;

    private Integer weight;

    private String mainIp;

    private String backIp;

    private Integer port;

    private Integer sInit;

    private Integer rInit;

    private Integer rCacheSize;

    private Integer sCacheSize;

    private Integer pubAddrSize;

    private Integer reasonSize;

    private Integer infoAddrSize;

    private Integer timer0;

    private Integer timer1;

    private Integer timer2;

    private Integer timer3;

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

    public Integer getsInit() {
        return sInit;
    }

    public void setsInit(Integer sInit) {
        this.sInit = sInit;
    }

    public Integer getrInit() {
        return rInit;
    }

    public void setrInit(Integer rInit) {
        this.rInit = rInit;
    }

    public Integer getrCacheSize() {
        return rCacheSize;
    }

    public void setrCacheSize(Integer rCacheSize) {
        this.rCacheSize = rCacheSize;
    }

    public Integer getsCacheSize() {
        return sCacheSize;
    }

    public void setsCacheSize(Integer sCacheSize) {
        this.sCacheSize = sCacheSize;
    }

    public Integer getPubAddrSize() {
        return pubAddrSize;
    }

    public void setPubAddrSize(Integer pubAddrSize) {
        this.pubAddrSize = pubAddrSize;
    }

    public Integer getReasonSize() {
        return reasonSize;
    }

    public void setReasonSize(Integer reasonSize) {
        this.reasonSize = reasonSize;
    }

    public Integer getInfoAddrSize() {
        return infoAddrSize;
    }

    public void setInfoAddrSize(Integer infoAddrSize) {
        this.infoAddrSize = infoAddrSize;
    }

    public Integer getTimer0() {
        return timer0;
    }

    public void setTimer0(Integer timer0) {
        this.timer0 = timer0;
    }

    public Integer getTimer1() {
        return timer1;
    }

    public void setTimer1(Integer timer1) {
        this.timer1 = timer1;
    }

    public Integer getTimer2() {
        return timer2;
    }

    public void setTimer2(Integer timer2) {
        this.timer2 = timer2;
    }

    public Integer getTimer3() {
        return timer3;
    }

    public void setTimer3(Integer timer3) {
        this.timer3 = timer3;
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