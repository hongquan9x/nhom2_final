package com.nhom2.cinemamanagement.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nhom2.cinemamanagement.models.Moives;

@Repository
public interface MoivesRepostiopry extends JpaRepository<Moives, Integer> {
	
	@Query("SELECT moives FROM Moives moives WHERE moives.moviename =:moviename")
	public Moives getByName(@Param("moviename") String moviename);
}
