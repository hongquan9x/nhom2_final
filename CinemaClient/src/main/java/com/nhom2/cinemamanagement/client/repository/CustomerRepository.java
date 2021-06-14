package com.nhom2.cinemamanagement.client.repository;



import com.nhom2.cinemamanagement.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("select customer from Customer customer where customer.customerEmail =:customerEmail")
    public Customer getCustomerByCustomerEmail(@Param("customerEmail") String email);
}
