package com.ems.dao;

import com.ems.model.Employee;
import com.ems.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class EmployeeDAO {
	public boolean addEmployee(Employee employee) throws SQLException {
		
		String SQL = "INSERT INTO employees "
		           + "(employee_name, email, salary, department) "
		           + "VALUES (?, ?, ?, ?)";
		
		try(Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(SQL)){
		
		ps.setString(1, employee.getEmployeeName());
		ps.setString(2, employee.getEmail());
		ps.setDouble(3, employee.getSalary());
		ps.setString(4, employee.getDepartment());
		
		int result = ps.executeUpdate();
	
		return result>0;
		
	}
}
	
	public boolean updateEmployee(Employee employee) throws SQLException {
		
		String SQL = "UPDATE employees SET "
                + "employee_name = ?, "
                + "email = ?, "
                + "salary = ?, "
                + "department = ? "
                + "WHERE employee_id = ?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL)){
			
			ps.setString(1, employee.getEmployeeName());
			ps.setString(2, employee.getEmail());
			ps.setDouble(3, employee.getSalary());
			ps.setString(4, employee.getDepartment());
			ps.setInt(5, employee.getEmployeeId());
			
			int result = ps.executeUpdate();
			
			return result>0;
			
		}
		

	}
	
	public boolean deleteEmployee(int employeeId) throws SQLException{
		
		String SQL = "DELETE FROM employees WHERE employee_id=?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL)){
			
			ps.setInt(1, employeeId);
			
			int result = ps.executeUpdate();
			return result>0;
		}
	}
	
	public List<Employee> displayEmployees() throws SQLException {
		List<Employee> employees = new ArrayList<>();
		
		String SQL = "SELECT * FROM employees";
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL);
				ResultSet rs = ps.executeQuery()){
					
					while(rs.next()) {
						
						Employee employee = new Employee();
						
						employee.setEmployeeid(rs.getInt("employee_id"));
						employee.setEmployeeName(rs.getString("employee_name"));
						employee.setEmail(rs.getString("email"));
						employee.setSalary(rs.getDouble("salary"));
						employee.setDepartment(rs.getString("department"));
						
						employees.add(employee);
					}
				}
		return employees;
	}
 	
	
	
	
	
	
	}


