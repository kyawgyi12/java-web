package com.jdc.jsf.model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.jsf.entity.Contact;
import com.jdc.jsf.service.ContactModel;

@Named
@RequestScoped
public class ContactDetails {
	
	private Contact contact;
	
	@Inject
	private ContactModel model;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	@PostConstruct
	private void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		String id = context.getExternalContext().getRequestParameterMap().get("id");
		contact = model.findById(Integer.parseInt(id));
	}

}
