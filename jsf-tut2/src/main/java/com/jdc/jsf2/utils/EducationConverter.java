package com.jdc.jsf2.utils;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.jdc.jsf2.data.Education;

@FacesConverter("eduConverter")
public class EducationConverter implements Converter{
	
	@Inject
	private List<Education> educations;
	


	@Override
	public Object getAsObject(FacesContext ctx, UIComponent ui, String str) {
		if(null != str) {
			return educations.stream().filter(edu -> edu.toString().equals(str)).findAny().orElse(Education.College);
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent ui, Object obj) {
		
		if(null != obj && obj instanceof Education) {
			return ((Education)obj).getValue();
		}
		
		return null;
	}

}
