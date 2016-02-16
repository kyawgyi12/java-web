package com.jdc.serv4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie [] cks = request.getCookies();
		
		String val = null;
		
		if(null != cks) {
			for(Cookie ck : cks) {
				if(ck.getName().equals("COUNTER")) {
					val = ck.getValue();
				}
			}
		}
		
		Counter c = new Counter(val);
		c.countUp();
		request.setAttribute("COOKIE_COUNTER", c);
		
		Cookie ck = new Cookie("COUNTER", c.toString());
		response.addCookie(ck);
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}


}
