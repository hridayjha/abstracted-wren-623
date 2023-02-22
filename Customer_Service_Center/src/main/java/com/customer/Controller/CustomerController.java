package com.customer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.Entity.Customer;
import com.customer.Service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CustomerController {
    @Autowired
	private CustomerService customerService;
    
    @PostMapping("/register")
    public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){
    	Customer customer1 = customerService.registerCustomer(customer);
    	
    	return new ResponseEntity<>(customer1, HttpStatus.ACCEPTED);
    	
    }
	

}
