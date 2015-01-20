package com.jdc.web.serv.ch4.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet(urlPatterns="/student-add", loadOnStartup=1)
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/webch4")
	private DataSource ds;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// get param from request
		
		
		// add to table
		
		// forward to list
		request.getRequestDispatcher("student-list").forward(request, response);

	}

}
