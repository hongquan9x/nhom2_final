package com.nhom2.cinemamanagement.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties
@EntityScan({"com.nhom2.cinemamanagement.models"})
public class CinemaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaClientApplication.class, args);
    }

}
