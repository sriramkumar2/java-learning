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
			                String name = "Sriram";
			                //  takes an object as parameter here (convets automatically into Wrapper class)
			                request.setAttribute("username",name);
			                
			                RequestDispatcher rd = request.getRequestDispatcher("SecondServlet");
			                rd.forward(request,response);
			                		
		}
}
