package com.jdc.ygn.admin.app.controller;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import com.jdc.ygn.mvc.AbstractController;

@WebServlet({ "/upload", "/upload/*" })
@MultipartConfig
public class UploadController extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Override
	public void index() {
		loadView("upload/index");
	}

	public void restaurant() {
		// get upload file from request
		
		
		// model add
		
		// redirect to view
		redirect(baseUrl("restaurant"));
	}

	public void category() {
		// get upload file from request
		
		
		// model add
		
		// redirect to view
		redirect(baseUrl("upload/categories"));
	}
	
	public void categories() {
		// get data from model
		
		// load view
		loadView("upload/categories");
	}

}
