package com.customer.Service;

import java.util.List;

import com.customer.Entity.Department;
import com.customer.Entity.Issue;
import com.customer.Entity.Operator;
import com.customer.Exception.DepartmentException;

public interface AdminService {
	public Department addDepartment(Department d);
	public Department updateDepartment(Integer id,Department d) throws DepartmentException;
	public Department removeDepartment(Integer id) throws DepartmentException;
	public Department getDepartmentById(Integer id) throws DepartmentException;
	public Operator addOperator(Operator o);
	public Operator assignDeptToOperator(Integer oid,Integer did);
	public Operator updateOperator(Integer id,Operator o);
	public Operator deleteOperator(Integer id);
	public List<Operator> getAllOperators();
	public Operator getOperatorById(Integer id);
	public List<Operator> getAllOperatorWithDeptId(Integer id);
	public List<Issue> getAllOpenIssueWithOperatorById(Integer id);
	public List<Issue> getAllClosedIssueWithOperatorById(Integer id);
//	public List<ReportDTO> getReportForAllOperators();
}
