package com.jdc.jsf2.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class StudentRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Student> repo;
	
	@PostConstruct
	private void init() {
		repo = new ArrayList<>();
	}
	
	public void add(Student student) {
		repo.add(student);
	}
	
	@Named
	@Produces
	public List<Student> getAllStudents() {
		return repo;
	}

}
