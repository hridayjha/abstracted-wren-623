package com.customer.Service;

import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.Entity.CurrentUserSession;
import com.customer.Entity.Customer;
import com.customer.Entity.Issue;
import com.customer.Entity.Login;
import com.customer.Exception.CustomerException;
import com.customer.Repository.CurrentUserSessionRepository;
import com.customer.Repository.CustomerRepository;
import com.customer.Repository.IssueRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CurrentUserSessionRepository usersession;
	
	@Autowired
	private IssueRepository issueRepo;
	
	@Autowired
	CustomerRepository customerDao;
	
	@Autowired
	CurrentUserSessionRepository sessionDao;

	@Override
	public Customer registerCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}
	
	@Override
	public String changePassword(Login login) throws CustomerException {
		
		String msg=null;
		
		if (login.getUser_Type().equals("CUSTOMER")) {

			Customer existCustomer = customerDao.findByEmail(login.getEmail());

			if (existCustomer == null)
				throw new CustomerException("Please Enter a valid login");
			else
				existCustomer.setPassword(login.getPassword());
				customerDao.save(existCustomer);
				msg="Password Updated";
		}
		return msg;
	}

	@Override
	public String forgetPassword(Integer id) throws CustomerException {
		String msg=null;
		Customer existCustomer = customerDao.findByCustomerId(id);

		if (existCustomer == null)
			throw new CustomerException("Please Enter a valid CustomerId");
		else {
			existCustomer.setPassword("123@123");
			String p=existCustomer.getPassword();
			customerDao.save(existCustomer);
			msg="Your temporary  Password is 123@123";
		}
		return msg;
	}

	@Override
	public Customer emailPassword(Integer id,String key) throws CustomerException {
		
		Customer existCustomer = customerDao.findByCustomerId(id);

		if (existCustomer == null)
			throw new CustomerException("Please Enter a valid CustomerId");
		else {
				CurrentUserSession checkUser = sessionDao.findByUuid(key);

				if (checkUser == null) {
					throw new CustomerException("You have to Login first .");
				}
				
				return existCustomer;
		}
	}

	@Override
	public Issue viewissue(Integer id, String key) throws CustomerException {
		// TODO Auto-generated method stub
		CurrentUserSession cSession = usersession.findByUuid(key);
		
		if(cSession==null) {
			throw new CustomerException("Customers needs to login");
		}
		Optional<Issue> opt = issueRepo.findById(id);
		if(opt.isPresent()) {
			Issue i = opt.get();
			if(i.getCustomer().getCustomerId()==cSession.getId()) {
				return i;
			}
			else {
				throw new CustomerException("Issue does not belongs to you");
			}
		}
		else {
			throw new CustomerException("Issue Does not Exists");
		}
	}
	
	
}
