package com.practice.controller;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		String email=request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email.equals("admin@gmail.com")&&
			password.equals("admin@123")){
				request.setAttribute("message", "login Successfully");
			}
			else {
				request.setAttribute("message", "Invalid Login");
				
			}
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
