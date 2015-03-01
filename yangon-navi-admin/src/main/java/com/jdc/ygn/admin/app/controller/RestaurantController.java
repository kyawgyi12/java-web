package com.jdc.ygn.admin.app.controller;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.jdc.ygn.admin.app.model.CategoryModel;
import com.jdc.ygn.admin.app.model.PhoneModel;
import com.jdc.ygn.admin.app.model.RestaurantModel;
import com.jdc.ygn.admin.app.model.entity.Phone;
import com.jdc.ygn.admin.app.model.entity.Restaurant;
import com.jdc.ygn.admin.app.model.entity.RestaurantCategory;
import com.jdc.ygn.admin.app.view.RestaurantVO;
import com.jdc.ygn.mvc.AbstractController;
import com.jdc.ygn.sql.BaseModel;

@WebServlet(urlPatterns={"/restaurant", "/restaurant/*"})
public class RestaurantController extends AbstractController{

	private static final long serialVersionUID = 1L;
	private RestaurantModel model;
	private CategoryModel cm;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			model = new RestaurantModel(connection());
			cm = new CategoryModel(connection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void index() {
		request("list", model.getAllVO());
		forward("restaurant/list");
	}
	
	public void details() {
		RestaurantVO vo = vo();
		if(vo != null) {
			request("item", vo);
			forward("restaurant/details");
		} else {
			// error page
		}
	}
	
	public void create() {
		request("categories", cm.getAll());
		forward("restaurant/add");
	}
	
	public void save() throws SQLException {
		RestaurantVO vo = vo();
		if(vo != null) {
			// edit
			request("item", vo);
			forward("restaurant/edit");
		} else {
			// add new
			// get restaurant info from view
			Restaurant r = new Restaurant();
			r.setName(param("name"));
			r.setAddress(param("address"));
			r.setTownshipId(Long.parseLong(param("township_id")));
			r.setDescription(param("description"));
			r.setHomepage(param("homepage"));
			r.setEmail(param("email"));
			r.setOpening(param("opening"));
			r.setCreation(new Date());
			r.setModification(new Date());
			
			// create restaurant
			r = model.insert(r);
			
			// get phones
			PhoneModel pm = new PhoneModel(connection());
			
			// create phone
			String phones = param("phone");
			if(null != phones) {
				for(String s : phones.split(",")) {
					Phone p = new Phone();
					p.setRestaurantId(r.getId());
					p.setPhone(s.trim());
					pm.insert(p);
				}
			}
			
			BaseModel<RestaurantCategory> rcm =
					new BaseModel<RestaurantCategory>(RestaurantCategory.class, connection());
			
			// create restaurant category
			String [] cats = params("category");
			for (int i = 0; i < cats.length; i++) {
				RestaurantCategory rc = new RestaurantCategory();
				rc.setRestaurantId(r.getId());
				rc.setCategoryId(Long.parseLong(cats[i]));
				rcm.insert(rc);
			}
			
			vo = model.findViewById(r.getId());
		}
		
		redirect(url("restaurant/details?id=" + vo.getRestaurant().getId()));
	}
	
	public void edit() {
		RestaurantVO vo = vo();
		if(vo != null) {
			request("item", vo);
			forward("restaurant/edit");
		} else {
			// error page
		}
	}
	
	public void search() {
		
		String keyword = param("keyword");
		if(null == keyword || keyword.isEmpty()) {
			request("list", model.getAllVO());
		} else {
			request("list", model.search(keyword));
		}
		forward("restaurant/list");
	}
	
	private RestaurantVO vo() {
		String strId = param("id");
		if(null != strId && !strId.isEmpty()) {
			return model.findViewById(Long.parseLong(strId));
		}
		return null;
	}

}
