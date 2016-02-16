package com.jdc.jsf2.utils;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.jdc.jsf2.data.Course;

@FacesConverter("courseConverter")
public class CourseConverter implements Converter{
	
	@Inject
	private List<Course> courses;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String str) {
		if(null != str) {
			return courses.stream().filter(c -> c.toString().equals(str)).findAny().orElse(null);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		
		if(null != obj && obj instanceof Course) {
			return ((Course)obj).getName();
		}

		return null;
	}

}
