package com.jdc.jsf.model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.jsf.entity.Contact;
import com.jdc.jsf.service.ContactModel;

@Model
public class ContactController {
	
	private Contact newContact;
	private List<Contact> contactList;

	@Inject
	private ContactModel model;
	
	@PostConstruct
	private void init() {
		newContact = new Contact();
		contactList = model.getAll();
	}
	
	public List<Contact> getContactList() {
		return contactList;
	}
	
	public Contact getNewContact() {
		return newContact;
	}
	
	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	
	public void setNewContact(Contact newContact) {
		this.newContact = newContact;
	}
	
	public String create() {
		model.createContact(newContact);
		return "list?faces-redirect=true";
	}
	
	public void delete(Contact c) {
		model.delete(c);
		contactList = model.getAll();
	}
}
