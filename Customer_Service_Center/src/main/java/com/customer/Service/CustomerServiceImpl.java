package com.customer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.Entity.Customer;
import com.customer.Exception.CustomerException;
import com.customer.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
  
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer registerCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public String loginCustomer(Login login) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePassword(Login login) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgetPassword(Integer id) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer emailPassword(Integer id) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
