package com.yn.entity;

public class Com extends Base{
    private Integer portNumber;

    private Integer sendDelay;

    private Integer recvTimeout;

    private Integer baudRate;

    private String parity;

    private Integer dataBits;

    private Double stopBits;

    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    public Integer getSendDelay() {
        return sendDelay;
    }

    public void setSendDelay(Integer sendDelay) {
        this.sendDelay = sendDelay;
    }

    public Integer getRecvTimeout() {
        return recvTimeout;
    }

    public void setRecvTimeout(Integer recvTimeout) {
        this.recvTimeout = recvTimeout;
    }

    public Integer getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(Integer baudRate) {
        this.baudRate = baudRate;
    }

    public String getParity() {
        return parity;
    }

    public void setParity(String parity) {
        this.parity = parity == null ? null : parity.trim();
    }

    public Integer getDataBits() {
        return dataBits;
    }

    public void setDataBits(Integer dataBits) {
        this.dataBits = dataBits;
    }

    public Double getStopBits() {
        return stopBits;
    }

    public void setStopBits(Double stopBits) {
        this.stopBits = stopBits;
    }
}