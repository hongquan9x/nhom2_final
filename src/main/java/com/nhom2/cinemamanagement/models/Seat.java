package com.nhom2.cinemamanagement.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seat")

public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seatID;
	private String seatName;
	private Integer roomID;
	private Integer status;
	
	public Seat(Integer seatID, String seatName, Integer roomID, Integer status) {
		super();
		this.seatID = seatID;
		this.seatName = seatName;
		this.roomID = roomID;
		this.status = status;
	}
	public Integer getSeatID() {
		return seatID;
	}
	public void setSeatID(Integer seatID) {
		this.seatID = seatID;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public Integer getRoomID() {
		return roomID;
	}
	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
