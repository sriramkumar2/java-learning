package com.ems.service;

import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;
import java.sql.SQLException;
import java.util.List;
public class EmployeeService {
		
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	public boolean addEmployee(Employee employee) throws SQLException {
		
		return employeeDAO.addEmployee(employee);
	}
	
	public boolean updateEmployee(Employee employee) throws SQLException{
		return employeeDAO.updateEmployee(employee);
	}
	
	public boolean deleteEmployee(int employeeId) throws SQLException{
		
		return employeeDAO.deleteEmployee(employeeId);
	}
	
	public List<Employee> displayEmployees() throws SQLException{
		return employeeDAO.displayEmployees();
	}
	
	
}
