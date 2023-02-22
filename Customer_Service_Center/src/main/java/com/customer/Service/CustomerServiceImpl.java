package com.customer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.Entity.Customer;
import com.customer.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
  
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer registerCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}
	
	
}
