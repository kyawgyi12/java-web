package com.jdc.web.ch3.ep1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servlet_two", 
	urlPatterns = { "/servlet_two" },
	initParams = {
		@WebInitParam(name = "name", value = "Servlet Two")
})
public class ServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().log(String.format("# This is log from %s", getServletName()));

		PrintWriter pw = response.getWriter();
		
		pw.write("<html>");
		pw.write("<head>");
		pw.printf("<title>%s</title>\n", getInitParameter("name"));
		pw.write("</head>");

		pw.write("<body>");
		pw.printf("<h1>%s</h1>\n", getInitParameter("name"));

		pw.write("This is message from Servlet One");
		
		pw.write("<br />");
		pw.write("<a href='javascript:history.back();'>BACK</a>");
		pw.write("</body>");
		pw.write("</html>");
		
	}

}
