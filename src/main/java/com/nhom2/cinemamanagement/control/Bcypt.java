package com.nhom2.cinemamanagement.control;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Bcypt {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pass = encoder.encode("123");
        System.out.println(pass);
    }
}
