package com.nhom2.cinemamanagement.models.entities;

import lombok.Data;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Data
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="movie_id")
    private Integer id;

    @Column(name ="category_id")
    private Integer categoryID;

    @Column(name ="movie_name")
    private String movieName;

    @Column(name ="movie_desciption")
    private String movieDesciption;

    @Column(name ="movie_length")
    private String movieLength;

    @Column(name ="show_time")
    private Date showTime;

    private String image;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "movie")
    private Set<MovieDetail> movieDetail = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", updatable = false, insertable = false)
    private Schedule schedule;
}