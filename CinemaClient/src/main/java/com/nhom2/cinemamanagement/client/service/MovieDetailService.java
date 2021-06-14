package com.nhom2.cinemamanagement.client.service;

import java.util.List;

import javax.transaction.Transactional;

import com.nhom2.cinemamanagement.client.repository.MovieDetailRepository;
import com.nhom2.cinemamanagement.models.entities.MovieDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class MovieDetailService {

    @Autowired
    private MovieDetailRepository movieDetailRepository;

    public List<MovieDetail> getByMoviedetail(Integer movieID)
    {
        return movieDetailRepository.getByMovieID(movieID);
    }
}