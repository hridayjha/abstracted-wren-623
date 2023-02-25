package com.customer.Service;

import com.customer.Entity.Customer;
import com.customer.Entity.Login;
import com.customer.Exception.CustomerException;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer);
	
	public String changePassword(Login login) throws CustomerException;
	public String forgetPassword(Integer id) throws CustomerException;
	public Customer emailPassword(Integer id,String key) throws CustomerException;
}
