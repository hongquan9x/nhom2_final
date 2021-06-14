package com.nhom2.cinemamanagement.client.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OnAuthenSuccess implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String username = authentication.getName();
        System.out.println("onAuthenticationSuccess: loigin success. go to home:" + username);

        response.sendRedirect("/");
    }
}
