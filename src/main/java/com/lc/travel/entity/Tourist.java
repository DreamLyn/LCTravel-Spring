package com.lc.travel.entity;

public class Tourist {
    private Integer id;

    private String name;

    private Integer type;

    private String phone;

    private Integer seat;

    private Integer peer;

    private Integer peerState;

    private String locale;

    private String remark;

    private String time;

    private Integer travelId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getPeer() {
        return peer;
    }

    public void setPeer(Integer peer) {
        this.peer = peer;
    }

    public Integer getPeerState() {
        return peerState;
    }

    public void setPeerState(Integer peerState) {
        this.peerState = peerState;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale == null ? null : locale.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }
}