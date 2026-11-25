package com.practice.service;
import com.practice.dao.EmployeeDAO;
import com.practice.model.Employee;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
public class EmployeeService {
	private EmployeeDAO DAO = new EmployeeDAO();
	
	public boolean addEmployee(Employee employee) throws SQLException,IOException
	{
		return DAO.addEmployee(employee);
	}
	
	public List<Employee> displayEmployee() throws SQLException,IOException
	{
		return DAO.displayEmployees();
	}
	
}
