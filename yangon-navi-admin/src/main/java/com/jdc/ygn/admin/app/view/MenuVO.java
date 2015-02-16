package com.jdc.ygn.admin.app.view;

import java.io.Serializable;

import com.jdc.ygn.admin.app.model.entity.Menu;
import com.jdc.ygn.admin.app.model.entity.Photo;

public class MenuVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Menu menu;
	private Photo photo;

	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
}
