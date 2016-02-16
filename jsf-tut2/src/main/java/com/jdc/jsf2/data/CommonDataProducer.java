package com.jdc.jsf2.data;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class CommonDataProducer {
	
	@Named
	@Produces
	private List<Education> educations;
	
	@Named
	@Produces
	private List<Course> courses;
	
	@PostConstruct
	private void init() {
		educations = Arrays.asList(Education.values());
		courses = Arrays.asList(Course.values());
	}

}
