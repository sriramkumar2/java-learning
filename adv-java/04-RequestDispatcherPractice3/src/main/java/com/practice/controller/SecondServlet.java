package com.practice.controller;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import java.io.PrintWriter;
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		// First Servlet affects 2nd servlet as well just for practice we are adding Contentype
		response.setContentType("text/html");
		String MSG = "<h2>This content comes from SecondServlet </h2>";
		PrintWriter pw = response.getWriter();
		pw.println(MSG);
	}
}
