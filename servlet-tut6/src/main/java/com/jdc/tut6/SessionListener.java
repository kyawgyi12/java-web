package com.jdc.tut6;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    public void sessionCreated(HttpSessionEvent se)  { 
    	String id = se.getSession().getId();
    	System.out.println("Session has been created! : " + id);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
       	String id = se.getSession().getId();
    	System.out.println("Session has been deleted! : " + id);
     }

    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	String id = event.getSession().getId();
    	String name = event.getName();
    	String value = event.getValue().toString();
    	System.out.println("Session has been added a value : " + id);
    	System.out.println("Name : " + name);
    	System.out.println("Value : " + value);
    }

    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	String id = event.getSession().getId();
    	String name = event.getName();
    	String value = event.getValue().toString();
    	System.out.println("Session has been removed a value : " + id);
    	System.out.println("Name : " + name);
    	System.out.println("Value : " + value);
    }

    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	String id = event.getSession().getId();
    	String name = event.getName();
    	String value = event.getValue().toString();
    	System.out.println("Session has been replaced a value : " + id);
    	System.out.println("Name : " + name);
    	System.out.println("Value : " + value);
    }
	
}
