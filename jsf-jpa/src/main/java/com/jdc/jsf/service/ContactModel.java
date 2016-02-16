package com.jdc.jsf.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.jdc.jsf.entity.Contact;

@Local
public interface ContactModel extends Serializable {
	
	void createContact(Contact c);
	Contact findById(int id);
	List<Contact> getAll();
	void delete(Contact c); 
	void update(Contact c);

}
