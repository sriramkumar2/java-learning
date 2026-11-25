package com.practice.dao;
import java.sql.Connection;

import com.practice.model.Employee;
import java.io.*;
import java.util.*;
import com.practice.connection.ConnectionFactory;

import java.sql.*;
public class EmployeeDAO {
	
	public boolean addEmployee(Employee employee) throws IOException,SQLException
	{
		String SQL = "insert into employee (name,email,phone) values (?,?,?)";
		
		try(Connection con = ConnectionFactory.getConnection();
		PreparedStatement ps = con.prepareStatement(SQL)){
		ps.setString(1, employee.getName());
		ps.setString(2, employee.getEmail());
		ps.setString(3, employee.getPhone());
		
		int result = ps.executeUpdate();
		
		return result>0;
	}
	}
	
	public List<Employee> displayEmployees() throws IOException,SQLException
	{
		List<Employee> ls = new ArrayList<>();
		String SQL = "select * from employee";
		
		try(Connection con = ConnectionFactory.getConnection();
		PreparedStatement ps = con.prepareStatement(SQL);
		ResultSet rs = ps.executeQuery()){
		
		while(rs.next()) {
			Employee employee = new Employee();
			
			employee.setName(rs.getString("name"));
			employee.setEmail(rs.getString("email"));
			employee.setPhone(rs.getString("phone"));
			employee.setId(rs.getInt("id"));
			
			ls.add(employee);
			}
		
			
		}
		return ls;
	}
}
