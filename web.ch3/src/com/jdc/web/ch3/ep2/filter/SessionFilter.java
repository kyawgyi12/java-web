package com.jdc.web.ch3.ep2.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jdc.web.ch3.ep2.util.Const;
import com.jdc.web.ch3.ep2.util.Counter;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/ch3.ep2.sess")
public class SessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionFilter() {
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
		HttpSession session = ((HttpServletRequest)request).getSession(true);
		
		Counter c = (Counter) session.getAttribute(Const.COUNTER.toString());
		if(null == c) {
			c = new Counter();
			session.setAttribute(Const.COUNTER.toString(), c);
		}
		c.countUp();
		
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
