package com.nhom2.cinemamanagement.client.handler;

import com.nhom2.cinemamanagement.client.service.CustomOauth2User;
import com.nhom2.cinemamanagement.client.service.CustomerService;
import com.nhom2.cinemamanagement.models.appenum.AuthProvider;
import com.nhom2.cinemamanagement.models.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OnAuthen2Success extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private CustomerService customerService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {

        CustomOauth2User customOauth2User = (CustomOauth2User) authentication.getPrincipal();

        String email = customOauth2User.getEmail();
        String name = customOauth2User.getName();
        String servletPath = request.getServletPath();
        AuthProvider provider = AuthProvider.BASIC;

        if(servletPath.contains("google")) {
            provider = AuthProvider.GOOGLE;
        }

        Customer customer = customerService.getCustomerByEmail(email);
    }
}