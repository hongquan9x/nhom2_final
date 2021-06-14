package com.nhom2.cinemamanagement.client.repository;

import java.util.List;

import com.nhom2.cinemamanagement.models.entities.MovieDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface MovieDetailRepository extends JpaRepository<MovieDetail, Integer> {

    @Query("SELECT moviedetail FROM MovieDetail moviedetail WHERE moviedetail.movieID =:movieID")
    public List<MovieDetail> getByMovieID(@Param("movieID") int movieID);
}
