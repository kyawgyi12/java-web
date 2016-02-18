package com.jdc.tut6;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
public class RequestListener implements ServletRequestAttributeListener, ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("Request has been destroy!");
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("Initialize request : " + sre.getServletRequest().getRemoteAddr());
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  {
    	
    	String name = srae.getName();
    	String value = srae.getValue().toString();
    	
    	System.out.println("Request Attribute has been add");
    	System.out.println("Attribute Name : " + name);
    	System.out.println("Attribute Value : " + value);
    	
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	String name = srae.getName();
    	String value = srae.getValue().toString();
    	
    	System.out.println("Request Attribute has been replaced");
    	System.out.println("Attribute Name : " + name);
    	System.out.println("Attribute Value : " + value);

    }
	
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	String name = srae.getName();
    	String value = srae.getValue().toString();
    	
    	System.out.println("Request Attribute has been removed");
    	System.out.println("Attribute Name : " + name);
    	System.out.println("Attribute Value : " + value);
    }

}
