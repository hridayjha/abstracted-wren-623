package com.customer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.Entity.Department;
import com.customer.Entity.Issue;
import com.customer.Entity.Operator;
import com.customer.Exception.DepartmentException;
import com.customer.Exception.OperatorException;
import com.customer.Repository.DepartmentDao;
import com.customer.Repository.OperatorDao;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private OperatorDao od;
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
	public Department updateDepartment(Department d) throws DepartmentException{
//		finding if the current dept exists or not
		Optional<Department>opt=dd.findById(d.getDeptId());
		if(opt.isPresent())
		{
//			if exists then saving the dept object passed in the argument
			Department dept=dd.save(d);
			return dept;
		}
		else
		{
//			since dept id does not exist, throwing excpetion
			throw new DepartmentException("Department with ID "+d.getDeptId()+" does not exist");
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
//		getting operator obj after calling save method on operator o
		Operator op=od.save(o);
//		returning operator obj
		return op;
	}

	@Override
	public Operator assignDeptToOperator(Integer oid, Integer did) throws DepartmentException, OperatorException{
//		finding operator by id
		Optional<Operator>opt=od.findById(oid);
		if(opt.isPresent())
		{
//			if operator exists, then need to check if department with given id is present or not
			Operator o=opt.get();
			Optional<Department>opt2=dd.findById(did);
			if(opt2.isPresent())
			{
//				department also present, saving values to the database
				Department d=opt2.get();
				o.setDepartment(d);
				d.getOperators().add(o);
				dd.save(d);
//				returning operator object
				return o;
			}
			else
			{
				throw new DepartmentException("Department with ID "+did+" does not exist");
			}
		}
		else
		{
			throw new OperatorException("Operator with ID "+oid+" does not exist");
		}
	}

	@Override
	public Operator updateOperator(Integer id, Operator o) throws OperatorException {
//		finding operator by given id
		Optional<Operator>opt=od.findById(id);
		if(opt.isPresent())
		{
//			if present then saving the operator object passed in the parameter
			Operator op=od.save(o);
//			returning operator object
			return op;
		}
		else
		{
			throw new OperatorException("Operator with ID "+id+" does not exist");
		}
		
	}

	@Override
	public Operator deleteOperator(Integer id) throws OperatorException{
//		finding operator by given id
		Optional<Operator>opt=od.findById(id);
		if(opt.isPresent())
		{
//			getting operator object if present and deleting from database
			Operator o=opt.get();
			od.delete(o);
//			returning operator object
			return o;
		}
		else
		{
			throw new OperatorException("Operator with ID "+id+" does not exist");
		}
	}

	@Override
	public List<Operator> getAllOperators() {
		List<Operator>list=od.findAll();
		return list;
	}

	@Override
	public Operator getOperatorById(Integer id) throws OperatorException{
//		finding operator by id
		Optional<Operator>opt=od.findById(id);
		if(opt.isPresent())
		{
//			if present then return the operator obj
			Operator o=opt.get();
			return o;
		}
		else
		{
			throw new OperatorException("Operator with ID "+id+" does not exist");
		}		
	}

	@Override
	public List<Operator> getAllOperatorWithDeptId(Integer id) throws DepartmentException{
		Optional<Department>opt=dd.findById(id);
		if(opt.isPresent())
		{
			Department d=opt.get();
			return d.getOperators();
		}
		else
		{
			throw new DepartmentException("Department with ID "+id+" does not exist");
		}
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
