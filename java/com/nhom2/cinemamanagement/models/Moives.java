package com.nhom2.cinemamanagement.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Moives {

	@Id
	@Column(name = "movieID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String categoryID;

	private String moviename;

	@Column(name = "moviedesciption")
	private String Desciption;

	private String movielength;

	private Date showtime;

	private String image;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getDesciption() {
		return Desciption;
	}

	public void setDesciption(String desciption) {
		Desciption = desciption;
	}

	public String getMovielength() {
		return movielength;
	}

	public void setMovielength(String movielength) {
		this.movielength = movielength;
	}

	public Date getShowtime() {
		return showtime;
	}

	public void setShowtime(Date showtime) {
		this.showtime = showtime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
