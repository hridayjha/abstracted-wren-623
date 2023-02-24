package com.customer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.Entity.Customer;
import com.customer.Entity.Login;
import com.customer.Exception.CustomerException;
import com.customer.Service.CustomerService;



@RestController
public class CustomerController {
    @Autowired
	private CustomerService customerService;
    
    @PostMapping("/register")
    public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){
    	Customer customer1 = customerService.registerCustomer(customer);
    	
    	return new ResponseEntity<>(customer1, HttpStatus.ACCEPTED);
    	
    }
    @PutMapping("/changepassword")
    public ResponseEntity<String> changePasswordHandler(@RequestBody Login login) throws CustomerException{
    	
    	String massage=customerService.changePassword(login);
    	
    	return new ResponseEntity<String>(massage, HttpStatus.OK);
    	
    }
    @PostMapping("/forgetPassword/{id}")
    public ResponseEntity<String> forgetPasswordHandler (@PathVariable("id")Integer id)  throws CustomerException{
    	
    	String massage=customerService.forgetPassword(id);
    	
    	return new ResponseEntity<String>(massage, HttpStatus.OK);
    	
    }
    @PostMapping("/emailPassword/{id}")
    public ResponseEntity<Customer> emailPasswordHandler (@PathVariable("id")Integer id)  throws CustomerException{
    	
    	Customer massage=customerService.emailPassword(id);
    	
    	return new ResponseEntity<Customer>(massage, HttpStatus.OK);
    	
    }

	

}
