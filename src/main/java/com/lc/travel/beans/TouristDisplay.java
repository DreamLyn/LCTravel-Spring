package com.lc.travel.beans;

import java.util.ArrayList;

public class TouristDisplay {
	private String name;

	private String seatsdesc;

	private String phone;

	private String seats;///此人的所有座位

	private Integer peer;

	private Integer peerState;

	private String remark;

	private Integer travelId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeatsdesc() {
		return seatsdesc;
	}

	public void setSeatsdesc(String seatsdesc) {
		this.seatsdesc = seatsdesc;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getTravelId() {
		return travelId;
	}

	public void setTravelId(Integer travelId) {
		this.travelId = travelId;
	}
	
	
}
