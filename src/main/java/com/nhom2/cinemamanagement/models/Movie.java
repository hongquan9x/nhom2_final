package com.nhom2.cinemamanagement.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movieID;
	private Integer categoryID;
	private String movieName;
	private String movieDesciption;
	private String movieLength;
	private Date showTime;
	
	public Movie(Integer movieID, Integer categoryID, String movieName, String movieDesciption, String movieLength,
			Date showTime) {
		super();
		this.movieID = movieID;
		this.categoryID = categoryID;
		this.movieName = movieName;
		this.movieDesciption = movieDesciption;
		this.movieLength = movieLength;
		this.showTime = showTime;
	}
	public Integer getMovieID() {
		return movieID;
	}
	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}
	public Integer getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDesciption() {
		return movieDesciption;
	}
	public void setMovieDesciption(String movieDesciption) {
		this.movieDesciption = movieDesciption;
	}
	public String getMovieLength() {
		return movieLength;
	}
	public void setMovieLength(String movieLength) {
		this.movieLength = movieLength;
	}
	public Date getShowTime() {
		return showTime;
	}
	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}
}
