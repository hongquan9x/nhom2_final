package com.nhom2.cinemamanagement.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int customerID;
    private String customerName;
    private String customerPhoneNumber;
    private float cumulativePoints;
    private String customerEmail;
    private String customerPassword;
    private String author_provider;
}
