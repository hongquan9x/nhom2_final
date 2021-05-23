package com.nhom2.cinemamanagement.service;

import com.nhom2.cinemamanagement.dao.CustomerRepository;
import com.nhom2.cinemamanagement.model.Customer;
import com.nhom2.cinemamanagement.security.MyCustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerDetailsServiceImp implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Customer customer =customerRepository.getCustomerByCustomerEmail(email);

        if (customer == null) {
            System.out.println("loadUserByUsername with not found email");
            throw new UsernameNotFoundException("User not found");
        }

        System.out.println("Load by email: "+customer.getCustomerEmail());
        return new MyCustomerDetails(customer);
    }
}
