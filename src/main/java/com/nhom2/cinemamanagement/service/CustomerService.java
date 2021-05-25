package com.nhom2.cinemamanagement.service;


import com.nhom2.cinemamanagement.dao.CustomerRepository;
import com.nhom2.cinemamanagement.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerByEmail (String email){
        return customerRepository.getCustomerByCustomerEmail(email);
    }
}
