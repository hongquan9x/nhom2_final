package com.nhom2.cinemamanagement.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invoiceID;
	private Date timeCheckIn;
	private Integer staffID;
	private Integer customerID;
	private Integer roomID;
	private Integer seatID;
	private Float discount;
	

	public Ticket(Integer invoiceID, Date timeCheckIn, Integer staffID, Integer customerID, Integer roomID,
			Integer seatID, Float discount) {
		super();
		this.invoiceID = invoiceID;
		this.timeCheckIn = timeCheckIn;
		this.staffID = staffID;
		this.customerID = customerID;
		this.roomID = roomID;
		this.seatID = seatID;
		this.discount = discount;
	}

	public Integer getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(Integer invoiceID) {
		this.invoiceID = invoiceID;
	}

	public Date getTimeCheckIn() {
		return timeCheckIn;
	}

	public void setTimeCheckIn(Date timeCheckIn) {
		this.timeCheckIn = timeCheckIn;
	}

	public Integer getStaffID() {
		return staffID;
	}

	public void setStaffID(Integer staffID) {
		this.staffID = staffID;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public Integer getRoomID() {
		return roomID;
	}

	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}

	public Integer getSeatID() {
		return seatID;
	}

	public void setSeatID(Integer seatID) {
		this.seatID = seatID;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

}
