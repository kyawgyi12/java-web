package com.jdc.web.ch3.ep1;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, 
		filterName = "filter_one", urlPatterns = { "/filter_one" }, 
		servletNames = { "servlet_one" })
public class FilterOne implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// place your code here
		request.getServletContext().log("#Log from Filter One before request");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		request.getServletContext().log("#Log from After One before request");
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
