package com.nhom2.cinemamanagement.client.service;

import com.nhom2.cinemamanagement.client.repository.CustomerRepository;
import com.nhom2.cinemamanagement.client.sercurity.MyCustomerDetails;
import com.nhom2.cinemamanagement.models.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
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
