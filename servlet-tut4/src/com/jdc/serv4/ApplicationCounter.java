package com.jdc.serv4;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplicationCounter extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext ctx = getServletContext();
		Counter c = (Counter) ctx.getAttribute("COUNTER");
		
		if(null == c) {
			c = new Counter();
			ctx.setAttribute("COUNTER", c);
		}
		
		c.countUp();
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}

}
