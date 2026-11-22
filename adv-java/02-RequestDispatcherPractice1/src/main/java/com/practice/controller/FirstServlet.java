package com.practice.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		System.out.println("First Servlet Executed");
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("SecondServlet");
		
		rd.forward(request,response);
	}
}
