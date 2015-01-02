package com.jdc.web.ch3.ep2.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.jdc.web.ch3.ep2.util.Const;
import com.jdc.web.ch3.ep2.util.Counter;

/**
 * Servlet Filter implementation class ApplicationFilter
 */
@WebFilter({ "/ch3.ep2.app", "/ch3.ep2.sess", "/ch3.ep2.req" })
public class ApplicationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ApplicationFilter() {
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
		ServletContext ctx = request.getServletContext();
		Counter appCounter = (Counter) ctx.getAttribute(Const.COUNTER.toString());
		
		if(null == appCounter) {
			appCounter = new Counter();
			request.getServletContext().setAttribute(Const.COUNTER.toString(), appCounter);
		}
		
		appCounter.countUp();
		
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
