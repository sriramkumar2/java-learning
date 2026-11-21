package com.ems.controller;
import jakarta.servlet.ServletException;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ems.model.Employee;
import java.io.IOException;
import com.ems.service.EmployeeService;
import java.sql.SQLException;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	
	private EmployeeService employeeService = new EmployeeService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Employee> employees =  employeeService.displayEmployees();
			
			request.setAttribute("employees", employees);
			
			request.getRequestDispatcher("viewEmployees.jsp").forward(request, response);
					
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new ServletException("Unable to retrieve employees",e);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String action = request.getParameter("action");
		try {
		
		
		if("update".equals(action)) {
			int employeeId = Integer.parseInt(request.getParameter("employeeId"));
			String name = request.getParameter("employeeName");
			String email = request.getParameter("email");
			double salary = Double.parseDouble(request.getParameter("salary"));
			String department = request.getParameter("department");
			Employee employee = new Employee(employeeId,name,email,salary,department);
			
			boolean result = employeeService.updateEmployee(employee);
			
			if(result) {
				response.getWriter().println("Employee Updated Successfully");
			}
			else {
				response.getWriter().println("Employee Update Failed");
				
			}
		}
		
		
		else if("add".equals(action)){
			String name = request.getParameter("employeeName");
			String email = request.getParameter("email");
			String salary = request.getParameter("salary");
			String department = request.getParameter("department");
			double empSalary = Double.parseDouble(salary);
			Employee employee = new Employee(0,name,email,empSalary,department);
			
			boolean result = employeeService.addEmployee(employee);
			
			if(result) {
				response.getWriter().println("Employee Added Successfully!");
			}
			else {
				response.getWriter().println("Employee Insertion Failed");
			}

		}
		else if("delete".equals(action)) {
			int employeeId = Integer.parseInt(request.getParameter("employeeId"));
			boolean result = employeeService.deleteEmployee(employeeId);
			
			if(result) {
				response.getWriter().println("Employee Deleted Successfully!");
				
			}
			else {
				response.getWriter().println("Employee Deleteion Failed!");
			}
			response.getWriter().println("<br><br>");
			response.getWriter().println("<a href='index.html'>Back to Home</a>");
		}
		else {
			response.getWriter().println("Invalid Action!");
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
			throw new ServletException("EMployee operation failed",e);
		}
		
		
		
		
		
		
		
	}

}
