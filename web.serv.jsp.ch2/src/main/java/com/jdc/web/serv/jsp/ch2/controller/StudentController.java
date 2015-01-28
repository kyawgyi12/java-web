package com.jdc.web.serv.jsp.ch2.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.jdc.web.serv.jsp.ch2.fw.Controller;
import com.jdc.web.serv.jsp.ch2.fw.MappingUrl;
import com.jdc.web.serv.jsp.ch2.model.Student;
import com.jdc.web.serv.jsp.ch2.model.StudentModel;

@WebServlet("/students/*")
public class StudentController extends Controller {

	// create model
	private StudentModel model;
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		super.init();
		model = StudentModel.model(ds());
	}
	
	@MappingUrl(url="list")
	private void list() {
		// title
		addForView("title", "Student List");
		
		// set data for view
		addForView("list", model.getAll());
		
		// load view
		loadView("student/list");
	}
	
	@MappingUrl(url="details")
	private void get() {
		
		// title
		addForView("title", "Student Details");

		// get view param
		int id = Integer.parseInt(param("id"));
		
		// set data for view
		addForView("item", model.findById(id));
		
		// load view
		loadView("student/details");
	}
	
	@MappingUrl(url="delete")
	private void delete() {
		// get view param
		int id = Integer.parseInt(param("id"));

		model.delete(id);
		
		// title
		addForView("title", "Student List");
		// set data for view
		addForView("list", model.getAll());
		
		// load view
		loadView("student/list");
	}
	
	
	@MappingUrl(url="add")
	private void add() {
		// title
		addForView("title", "Add New Student");
		// load view
		loadView("student/add");
	}
	
	@MappingUrl(url="edit")
	private void edit() {
		// get view param
		int id = Integer.parseInt(param("id"));
		
		// title
		addForView("title", "Edit Student");
		// set data for view
		addForView("item", model.findById(id));

		// load view
		loadView("student/edit");
	}

	@MappingUrl(url="save")
	private void save() {
		
		Student s = getParams(Student.class);
		
		if(s.getId() == null) {
			model.addStudent(s);
		} else {
			model.update(s);
		}
		
		// title
		addForView("title", "Student List");
		// set data for view
		addForView("list", model.getAll());
		
		// load view
		loadView("student/list");
	}

}
