package com.jdc.web.ch3.ep2.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.jdc.web.ch3.ep2.util.Const;
import com.jdc.web.ch3.ep2.util.Counter;

/**
 * Servlet Filter implementation class RequestFilter
 */
@WebFilter("/ch3.ep2.req")
public class RequestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RequestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		Counter reqCounter = (Counter) request.getAttribute(Const.COUNTER.toString());
		if(null == reqCounter) {
			reqCounter = new Counter();
			request.setAttribute(Const.COUNTER.toString(), reqCounter);
		}
		reqCounter.countUp();
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
