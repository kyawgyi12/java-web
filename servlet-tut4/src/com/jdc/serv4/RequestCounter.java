package com.jdc.serv4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestCounter extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final String COUNTER = "COUNTER";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Counter c = (Counter) req.getAttribute(COUNTER);
		
		if(c == null) {
			c = new Counter();
			c.countUp();
			req.setAttribute(COUNTER, c);
		}
		
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}

}
