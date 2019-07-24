package com.ot.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8985359041905445960L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			String password = request.getParameter("pass");
			
			if (password.equals("studytonight")) {
				RequestDispatcher rd = request.getRequestDispatcher("/HelloWorld");
				rd.forward(request,response);
			} else {
				out.println("<font color='red'><b>You have entered incorrect password.</b></font>");
				RequestDispatcher rd = request.getRequestDispatcher("pages/index.html");
				rd.include(request, response);
			}
		} finally {
			out.close();
		}
	}

}
