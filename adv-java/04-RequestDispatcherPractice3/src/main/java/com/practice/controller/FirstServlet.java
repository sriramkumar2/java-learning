package com.practice.controller;
import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		response.getWriter().println("<h2>Welcome to FirstServlet</h2>");
		
		 RequestDispatcher rd =
	                request.getRequestDispatcher("SecondServlet"); 
		 
		 rd.include(request,response);
		 
		 response.getWriter().println("<p>FirstServlet execution continues after include</p>");
	}
}
