package com.nhom2.cinemamanagement.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nhom2.cinemamanagement.models.Food;

public interface FoodRepositopry extends JpaRepository<Food, Integer> {

	@Query("SELECT food FROM food food WHERE food.unit = :unit")
	public Food getbyFood(@Param("unit") String unit);
}
