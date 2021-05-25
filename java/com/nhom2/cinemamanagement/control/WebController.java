package com.nhom2.cinemamanagement.control;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.nhom2.cinemamanagement.controllers.services.MoivesService;
import com.nhom2.cinemamanagement.models.Moives;


@Controller
public class WebController {
	@Autowired()
	private MoivesService moivesService;

    @GetMapping("/")
    public String homePage(Model model){
    	List<Moives> allmoives = moivesService.GetMoivesAll();
    	model.addAttribute("allmoives", allmoives);
        return "index";
    }
    @GetMapping("/movie-page-left.html")
    public String loadmovies(Model model)
    {
    	return "movie-page-left.html";
    }
    @GetMapping("edit/{id}")
	public ModelAndView updateProduct(@PathVariable(name="id")Integer id) {
		ModelAndView modelandview = new ModelAndView("movie-page-left");
		Moives product = moivesService.get(id);
		modelandview.addObject(product);
		return modelandview;
	}
}
