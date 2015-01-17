package com.jdc.web.serv.ch3.ep1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletFilter2 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		ServletContext context = request.getServletContext();
		
		context.log("Message from Filter2 before request");
		request.setAttribute("Attribute", "Message from Filter 2");
		chain.doFilter(request, response);
		context.log("Message from Filter2 after request");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
