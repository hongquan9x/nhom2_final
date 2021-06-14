package com.nhom2.cinemamanagement.client.service;


import java.util.List;

import javax.transaction.Transactional;

import com.nhom2.cinemamanagement.client.repository.MovieRepository;
import com.nhom2.cinemamanagement.models.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return  movieRepository.findAll();
    }
    public Movie getByName(String movieName) {
        return movieRepository.getByName(movieName);
    }

    public Movie get(Integer id) {
        return movieRepository.findById(id).get();
    }
}