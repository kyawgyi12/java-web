package com.jdc.serv.forward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForwardTwo")
public class ForwardTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("HeaderServlet").include(request, response);
		
		response.getWriter().append(request.getAttribute("message").toString());

		response.getWriter().append("<br/>");

		response.getWriter().append("Message from Forward Two");

		request.getRequestDispatcher("FooterServlet").include(request, response);
	}


}
