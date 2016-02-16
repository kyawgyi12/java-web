package com.jdc.serv4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		Counter c = (Counter) session.getAttribute("COUNTER");
		if(null == c) {
			c = new Counter();
			session.setAttribute("COUNTER", c);
		}
		
		c.countUp();
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
