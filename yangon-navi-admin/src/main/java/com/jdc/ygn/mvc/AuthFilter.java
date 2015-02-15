package com.jdc.ygn.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jdc.ygn.admin.app.model.entity.User;

@WebFilter(urlPatterns={"/user", "/user/*", "/restaurant", "/restaurant/*", "/menu", "/menu/*"})
public class AuthFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession(true);
		User login = (User) session.getAttribute("login");
		if(null == login) {
			List<String> message = new ArrayList<String>();
			message.add("You need to login for this application");
			request.setAttribute("message", message);
			request.getServletContext().getRequestDispatcher("/login").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
