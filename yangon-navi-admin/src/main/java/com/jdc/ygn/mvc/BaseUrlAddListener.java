package com.jdc.ygn.mvc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BaseUrlAddListener implements ServletContextListener {

	private BaseUrl base;
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  { 
		base = new BaseUrl(sce.getServletContext().getContextPath());
		sce.getServletContext().setAttribute("baseUrl", base);
   }
	
}
