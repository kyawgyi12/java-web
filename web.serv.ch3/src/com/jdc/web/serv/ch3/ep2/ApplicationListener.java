package com.jdc.web.serv.ch3.ep2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().log("Message Servlet Context Initialized");
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

}
