package com.practice.controller;
import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import java.io.PrintWriter;
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		// request.getAttribute() returns an object
		String username = (String) request.getAttribute("username");
		
		String MSG = "<h2>Welcome," + username + "</h2>";
		
		PrintWriter pw = response.getWriter().append(MSG); 
		
	}

}
