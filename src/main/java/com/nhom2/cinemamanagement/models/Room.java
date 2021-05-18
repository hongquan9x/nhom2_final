package com.nhom2.cinemamanagement.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roomID;
	private String roomName;
	private Integer amountOfSeats;
	
	public Room(Integer roomID, String roomName, Integer amountOfSeats) {
		super();
		this.roomID = roomID;
		this.roomName = roomName;
		this.amountOfSeats = amountOfSeats;
	}
	public Integer getRoomID() {
		return roomID;
	}
	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Integer getAmountOfSeats() {
		return amountOfSeats;
	}
	public void setAmountOfSeats(Integer amountOfSeats) {
		this.amountOfSeats = amountOfSeats;
	}
	
}
