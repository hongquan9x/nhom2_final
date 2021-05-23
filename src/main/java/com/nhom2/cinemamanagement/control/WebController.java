package com.nhom2.cinemamanagement.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String homePage(){
        return "index";
    }


    @GetMapping("/login")
    public String loginCustomer(){
        return "login";
    }

    @GetMapping("/login_error")
    public String showLoginError(){
        return "login_error";
    }

}
