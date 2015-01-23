package com.jdc.web.serv.ch4.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = { "/student-add", "/async-upload", "/student-upload",
		"/student-list" }, asyncSupported = true)
public class HtmlFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		StringBuffer header = new StringBuffer();
		header.append("<!DOCTYPE html>");
		header.append("<html>");
		header.append("<head>");

		header.append("<meta charset='UTF-8'>");

		header.append("<title>Servlet Day 4</title>");
		header.append("<link href='resources/css/bootstrap.min.css' rel='stylesheet' />");
		header.append("<script type='text/javascript' src='resources/js/bootstrap.min.js'></script>");

		header.append("</head>");
		header.append("<body>");

		request.setAttribute("header", header);

		StringBuffer footer = new StringBuffer();

		footer.append("</body>");
		footer.append("</html>");
		request.setAttribute("footer", footer);

		chain.doFilter(request, response);

	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
