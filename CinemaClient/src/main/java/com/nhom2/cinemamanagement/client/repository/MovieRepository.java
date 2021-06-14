package com.nhom2.cinemamanagement.client.repository;

import com.nhom2.cinemamanagement.models.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT movie FROM Movie movie WHERE movie.movieName =:moviename")
    public Movie getByName(@Param("moviename") String movieName);

}