package com.jdc.jsf.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.jsf.entity.Contact;

@Local
@Stateless
public class ContactModelImp implements ContactModel {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private transient EntityManager em;

	@Override
	public void createContact(Contact c) {
		em.persist(c);
	}

	@Override
	public Contact findById(int id) {
		return em.find(Contact.class, id);
	}

	@Override
	public List<Contact> getAll() {
		TypedQuery<Contact> q = em.createNamedQuery("Contact.getAll", Contact.class);
		return q.getResultList();
	}

	@Override
	public void delete(Contact c) {
		c = em.find(Contact.class, c.getId());
		em.remove(c);
	}

	@Override
	public void update(Contact c) {
		em.merge(c);
	}

}
