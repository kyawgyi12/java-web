package com.jdc.web.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/parameter")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String TR_FORMAT = "<tr><td>%s</td><td>%s</td></tr>\n";
	private static final String HEAD = "<head><title>%s</title></head>\n";
	private static final String H1 = "<h1>%s</h1>\n";
	private static final String PARAM1 = "name";
	private static final String PARAM2 = "job";

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		// retrieve data from request
		String name = request.getParameter(PARAM1);
		String job = request.getParameter(PARAM2);
		
		// writing result to response
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.printf(HEAD, request.getMethod());
		pw.println("<body>");
		pw.printf(H1, request.getMethod());
		pw.println("<table>");
		pw.printf(TR_FORMAT, PARAM1, name);
		pw.printf(TR_FORMAT, PARAM2, job);
		pw.println("</table>");
		pw.println("<a href='javascript:history.back();'>Back</a>");
		pw.println("</body>");
		pw.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// retrieve data from request
		String name = request.getParameter(PARAM1);
		String job = request.getParameter(PARAM2);
		
		// writing result to response
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.printf(HEAD, request.getMethod());
		pw.println("<body>");
		pw.printf(H1, request.getMethod());
		pw.println("<table>");
		pw.printf(TR_FORMAT, PARAM1, name);
		pw.printf(TR_FORMAT, PARAM2, job);
		pw.println("</table>");
		pw.println("<a href='javascript:history.back();'>Back</a>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
