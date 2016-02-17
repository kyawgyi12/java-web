package com.jdc.tut5;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(
		urlPatterns = { 
				"/user/*"
		}, 
		initParams = { 
				@WebInitParam(name = "user", value = "jdc-user", description = "Login User"), 
				@WebInitParam(name = "pass", value = "jdcpass", description = "Password")
		})
public final class LoginFilter implements Filter {
	
	private String userId;
	private String pass;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		// check user in session
		if(null != session) {
			if(userId.equals(session.getAttribute("user")) 
					&& pass.equals(session.getAttribute("pass"))) {
				req.setAttribute("message", "Filter said : Login OK");
				chain.doFilter(request, response);
			} else {
				// redirect login page
				RequestDispatcher disp = req.getServletContext().getRequestDispatcher("/login.html");
				disp.forward(request, response);
			}
		
		} else {
			// redirect login page
			RequestDispatcher disp = req.getServletContext().getRequestDispatcher("/login.html");
			disp.forward(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		userId = fConfig.getInitParameter("user");
		pass = fConfig.getInitParameter("pass");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
