package com.practice.controller;
import com.practice.model.Employee;
import com.practice.service.EmployeeService;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet{
	
	private EmployeeService es = new EmployeeService();
		
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		try {
		List<Employee> ls = es.displayEmployee();
		request.setAttribute("employees", ls);
		RequestDispatcher rd = request.getRequestDispatcher("viewEmployees.jsp");
		rd.forward(request, response);
		}
		catch(SQLException e) {
			 e.printStackTrace();

			    request.setAttribute("error", "Unable to retrieve employee details.");

			    request.getRequestDispatcher("viewEmployees.jsp")
			           .forward(request, response);
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Employee employee = new Employee(0,name,email,phone);
		
		try{
			boolean result = es.addEmployee(employee);
			if(result) {
				request.setAttribute("message", "Reocrd Entered into DB !");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else {
				request.setAttribute("message", "Record Entered Failed ");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		catch(SQLException e) {
			 e.printStackTrace();

		        request.setAttribute("message",
		                "Something went wrong!");

		        request.getRequestDispatcher("/index.jsp")
		               .forward(request, response);
		}
	}
}
