package com.nhom2.cinemamanagement.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nhom2.cinemamanagement.daos.MoivesRepostiopry;
import com.nhom2.cinemamanagement.models.Moives;


@Service
@Transactional
public class MoivesService {
	
	@Autowired
	private MoivesRepostiopry moivesRepostiopry;
	
	public List<Moives> GetMoivesAll()
	{
		return  moivesRepostiopry.findAll();
	}
	public Moives getByName(String moivesname)
	{
		return moivesRepostiopry.getByName(moivesname);
	}
	public Moives get(Integer id) {
		return moivesRepostiopry.findById(id).get();
	}
}
