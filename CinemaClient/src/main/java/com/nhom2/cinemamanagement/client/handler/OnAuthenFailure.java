package com.nhom2.cinemamanagement.client.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OnAuthenFailure implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (exception instanceof UsernameNotFoundException) {
            UsernameNotFoundException ex = (UsernameNotFoundException) exception;
            System.out.println("Username Not found excpetion: " + ex.getMessage());
        }

        System.out.println("AuthenticationException: " + exception.getClass().getName());
        System.out.println("AuthenticationFailureHandler: fail to login");
        response.sendRedirect("/login_error");
    }
}