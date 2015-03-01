package com.jdc.ygn.mvc;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import com.jdc.ygn.admin.app.model.entity.Township;
import com.jdc.ygn.sql.BaseModel;

@WebListener
public class CommonDataUploadListener implements ServletContextListener {

	@Resource(name = "jdbc/yangon_navi")
	private DataSource ds;
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	sce.getServletContext().log("Application Context has been destroyed.");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
    		// townships
			BaseModel<Township> tspModel = new BaseModel<Township>(Township.class, ds.getConnection());
			sce.getServletContext().setAttribute("townships", tspModel.getAll());
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
}
