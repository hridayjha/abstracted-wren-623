package com.customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	 Customer findByEmail (String email);

//    @Query("SELECT c FROM Customer c WHERE c.email = :email")
//    Customer findByEmail( String email);
}
