package com.practice.controller;

import java.io.PrintWriter;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		
		String MSG = "<h2>Welcome! Second Servlet Executed Successfully.</h2>";
		
		PrintWriter pw = response.getWriter();
		pw.append(MSG);
				
	}
}
