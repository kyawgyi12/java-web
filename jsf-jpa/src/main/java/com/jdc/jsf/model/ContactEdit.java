package com.jdc.jsf.model;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.jsf.entity.Contact;
import com.jdc.jsf.service.ContactModel;

@Named
@ViewScoped
public class ContactEdit implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ContactModel model;
	
	private Contact contact;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@PostConstruct
	private void init() {
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		String id = ctx.getExternalContext().getRequestParameterMap().get("id");
		contact = model.findById(Integer.parseInt(id));
		
	}
	
	public String save() {
		model.update(contact);
		return "details?faces-redirect=true&id=" + contact.getId();
	}
	
}
