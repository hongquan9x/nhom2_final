package com.nhom2.cinemamanagement.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class Food {

	private Integer foodID;
	private String foodName;
	private Integer categoryID;
	private String unit;
	private Float price;
	
	public Food(Integer foodID, String foodName, Integer categoryID, String unit, Float price) {
		super();
		this.foodID = foodID;
		this.foodName = foodName;
		this.categoryID = categoryID;
		this.unit = unit;
		this.price = price;
	}
	public Integer getFoodID() {
		return foodID;
	}
	public void setFoodID(Integer foodID) {
		this.foodID = foodID;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Integer getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
}
