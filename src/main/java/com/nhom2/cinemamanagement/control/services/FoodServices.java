package com.nhom2.cinemamanagement.control.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom2.cinemamanagement.daos.FoodRepositopry;
import com.nhom2.cinemamanagement.models.Food;

@Service
public class FoodServices {
	
	@Autowired
	private FoodRepositopry repositopry;
	public List<Food> listAllFood(){
		return repositopry.findAll();
	}
	public Food getbyFood(String unit) {
		return repositopry.getbyFood(unit);
		
	}
	
}
