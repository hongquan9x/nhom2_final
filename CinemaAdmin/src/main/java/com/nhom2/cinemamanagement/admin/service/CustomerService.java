package com.nhom2.cinemamanagement.admin.service;


import com.nhom2.cinemamanagement.admin.repository.CustomerRepository;
import com.nhom2.cinemamanagement.models.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> listAllCustomer() {
        return customerRepository.findAll();
    }
}
