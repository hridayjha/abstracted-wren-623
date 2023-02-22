package com.customer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.Entity.Department;
import com.customer.Entity.Issue;
import com.customer.Entity.Operator;
import com.customer.Exception.DepartmentException;
import com.customer.Repository.DepartmentDao;

@Service
public class AdminServiceImpl implements AdminService{

//	@Autowired
//	private OperatorDao od;
	@Autowired
	private DepartmentDao dd;
	
	
	
	@Override
	public Department addDepartment(Department d) {
//		getting list of operators to map to department
		List<Operator>list=d.getOperators();
		for(Operator o:list)
		{
			o.setDepartment(d);
		}
//		getting dept object after calling save method with object d
		Department dept=dd.save(d);
//		returning dept object with updated primary key value
		return dept;
	}

	@Override
	public Department updateDepartment(Integer id, Department d) throws DepartmentException{
//		finding if the current dept exists or not
		Optional<Department>opt=dd.findById(id);
		if(opt.isPresent())
		{
//			if exists then saving the dept object passed in the argument
			Department dept=dd.save(d);
			return dept;
		}
		else
		{
//			since dept id does not exist, throwing excpetion
			throw new DepartmentException("Department with ID "+id+" does not exist");
		}
	}

	@Override
	public Department removeDepartment(Integer id) throws DepartmentException{
//		finding if the current dept exists or not
		Optional<Department>opt=dd.findById(id);
		if(opt.isPresent())
		{
//			if exists then deleting that object from database and returning to controller layer
			Department dept=opt.get();
			dd.delete(dept);
			return dept;
		}
		else
		{
//			since dept id does not exist, throwing excpetion
			throw new DepartmentException("Department with ID "+id+" does not exist");
		}
	}

	@Override
	public Department getDepartmentById(Integer id) throws DepartmentException{
//		finding if the current dept exists or not
		Optional<Department>opt=dd.findById(id);
		if(opt.isPresent())
		{
//			if exists then deleting that object from database and returning to controller layer
			Department d=opt.get();
			return d;
		}
		else
		{
//			since dept id does not exist, throwing excpetion
			throw new DepartmentException("Department with ID "+id+" does not exist");
		}

	}

	@Override
	public Operator addOperator(Operator o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operator assignDeptToOperator(Integer oid, Integer did) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operator updateOperator(Integer id, Operator o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operator deleteOperator(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operator> getAllOperators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operator getOperatorById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operator> getAllOperatorWithDeptId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issue> getAllOpenIssueWithOperatorById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issue> getAllClosedIssueWithOperatorById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
