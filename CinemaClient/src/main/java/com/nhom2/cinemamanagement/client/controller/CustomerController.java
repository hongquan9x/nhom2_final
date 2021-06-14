package com.nhom2.cinemamanagement.client.controller;

import com.nhom2.cinemamanagement.client.service.MovieDetailService;
import com.nhom2.cinemamanagement.client.service.MovieService;
import com.nhom2.cinemamanagement.models.entities.Movie;
import com.nhom2.cinemamanagement.models.entities.MovieDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieDetailService movieDetailService;

    @GetMapping("/")
    public String homePage(Model model) {

        List<Movie> listMovies = movieService.getAllMovies();

        model.addAttribute("allMovies", listMovies);

        return "index";
    }


    @GetMapping("/login")
    public String loginCustomer() {
        return "login";
    }

    @GetMapping("/login_error")
    public String showLoginError() {
        return "login_error";
    }

    @GetMapping("edit/{id}")
    public ModelAndView detailMovie(@PathVariable(name="id")Integer id) {

        ModelAndView modelandview = new ModelAndView("movie-page-left");

        Movie movie = movieService.get(id);

        List<MovieDetail> movieDetail = movieDetailService.getByMoviedetail(id);

        modelandview.addObject("movieDetail", movieDetail);
        modelandview.addObject(movie);

        return modelandview;
    }

}
