package com.nhom2.cinemamanagement.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticketdetails")

public class TicketDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invoiceID;
	private Integer foodID;
	private Integer amountOfFood;
	private Integer movieID;
	private Integer amountOfMovie;
	
	public TicketDetails(Integer invoiceID, Integer foodID, Integer amountOfFood, Integer movieID,
			Integer amountOfMovie) {
		super();
		this.invoiceID = invoiceID;
		this.foodID = foodID;
		this.amountOfFood = amountOfFood;
		this.movieID = movieID;
		this.amountOfMovie = amountOfMovie;
	}
	public Integer getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(Integer invoiceID) {
		this.invoiceID = invoiceID;
	}
	public Integer getFoodID() {
		return foodID;
	}
	public void setFoodID(Integer foodID) {
		this.foodID = foodID;
	}
	public Integer getAmountOfFood() {
		return amountOfFood;
	}
	public void setAmountOfFood(Integer amountOfFood) {
		this.amountOfFood = amountOfFood;
	}
	public Integer getMovieID() {
		return movieID;
	}
	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}
	public Integer getAmountOfMovie() {
		return amountOfMovie;
	}
	public void setAmountOfMovie(Integer amountOfMovie) {
		this.amountOfMovie = amountOfMovie;
	}
	
}
