package com.jdc.tut6;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextAttributeListener, ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Servlet Context has been created!");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Servlet Context has been destroyed!");
	}

	public void attributeAdded(ServletContextAttributeEvent event) {
		String name = event.getName();
		String value = event.getValue().toString();

		System.out.println("Attribute has been added to Servlet Context");
		System.out.println("Name : " + name);
		System.out.println("Value : " + value);
	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
		String name = event.getName();
		String value = event.getValue().toString();

		System.out.println("Attribute has been removed to Servlet Context");
		System.out.println("Name : " + name);
		System.out.println("Value : " + value);
	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
		String name = event.getName();
		String value = event.getValue().toString();

		System.out.println("Attribute has been replaced to Servlet Context");
		System.out.println("Name : " + name);
		System.out.println("Value : " + value);
	}

}
