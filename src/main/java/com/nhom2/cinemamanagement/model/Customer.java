package com.nhom2.cinemamanagement.model;




import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "customer_id")
    private int customerId;

    @Column (name  = "customer_name")
    private String customerName;

    @Column (name  = "customer_phone_number")
    private String customerPhoneNumber;

    @Column (name  = "cumulative_points")
    private float cumulativePoints;

    @Column (name  = "customer_email")
    private String customerEmail;

    @Column (name  = "customer_password")
    private String customerPassword;

    @Column (name  = "auth_provider")
    private String authProvider;

}
