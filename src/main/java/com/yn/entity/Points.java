package com.yn.entity;

public class Points extends Base{
    private String name;

    private String desc;

    private String cDev;

    private Integer cDevid;

    private String cInaddr;

    private String cIntype;

    private Integer cInbit;

    private String fDev;

    private Integer fDevid;

    private String fInaddr;

    private String fIntype;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getcDev() {
        return cDev;
    }

    public void setcDev(String cDev) {
        this.cDev = cDev == null ? null : cDev.trim();
    }

    public Integer getcDevid() {
        return cDevid;
    }

    public void setcDevid(Integer cDevid) {
        this.cDevid = cDevid;
    }

    public String getcInaddr() {
        return cInaddr;
    }

    public void setcInaddr(String cInaddr) {
        this.cInaddr = cInaddr == null ? null : cInaddr.trim();
    }

    public String getcIntype() {
        return cIntype;
    }

    public void setcIntype(String cIntype) {
        this.cIntype = cIntype == null ? null : cIntype.trim();
    }

    public Integer getcInbit() {
        return cInbit;
    }

    public void setcInbit(Integer cInbit) {
        this.cInbit = cInbit;
    }

    public String getfDev() {
        return fDev;
    }

    public void setfDev(String fDev) {
        this.fDev = fDev == null ? null : fDev.trim();
    }

    public Integer getfDevid() {
        return fDevid;
    }

    public void setfDevid(Integer fDevid) {
        this.fDevid = fDevid;
    }

    public String getfInaddr() {
        return fInaddr;
    }

    public void setfInaddr(String fInaddr) {
        this.fInaddr = fInaddr == null ? null : fInaddr.trim();
    }

    public String getfIntype() {
        return fIntype;
    }

    public void setfIntype(String fIntype) {
        this.fIntype = fIntype == null ? null : fIntype.trim();
    }
}