package com.jdc.jsf2;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.jsf2.data.Student;
import com.jdc.jsf2.data.StudentRepository;

@Model
public class SimpleValueBean {
	
	private Student student;

	@Inject
	private StudentRepository repo;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	@PostConstruct
	private void init() {
		student = new Student();
	}
	
	public String addStudent() {
		repo.add(student);
		return "simple-value?faces-recirect=true";
	}

}
