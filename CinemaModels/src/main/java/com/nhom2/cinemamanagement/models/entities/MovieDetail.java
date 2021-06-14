package com.nhom2.cinemamanagement.models.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="moviedetail")
@IdClass(MovieDetailPK.class)
public class MovieDetail implements Serializable {


    @Id
    @Column(name = "movie_id")
    private int movieID;

    @Id
    @Column(name = "movie_image")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    private Movie movie;

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}

