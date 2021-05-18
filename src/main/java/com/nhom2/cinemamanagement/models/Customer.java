package com.nhom2.cinemamanagement.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerID;
	private String customerName;
	private String customerPhoneNumber;
	private float cumulativePoints;
	
	public Customer(Integer customerID, String customerName, String customerPhoneNumber, float cumulativePoints) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
		this.cumulativePoints = cumulativePoints;
	}
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public float getCumulativePoints() {
		return cumulativePoints;
	}
	public void setCumulativePoints(float cumulativePoints) {
		this.cumulativePoints = cumulativePoints;
	}
	
}
