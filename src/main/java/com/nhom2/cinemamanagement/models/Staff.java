package com.nhom2.cinemamanagement.models;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff")

public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer staffID;
	private String staffName;
	private Date yearofbirth;
	private String address;
	private Integer role;
	public Staff(Integer staffID, String staffName, Date yearofbirth, String address, Integer role) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.yearofbirth = yearofbirth;
		this.address = address;
		this.role = role;
	}
	public Integer getStaffID() {
		return staffID;
	}
	public void setStaffID(Integer staffID) {
		this.staffID = staffID;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public Date getYearofbirth() {
		return yearofbirth;
	}
	public void setYearofbirth(Date yearofbirth) {
		this.yearofbirth = yearofbirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	
	
}
