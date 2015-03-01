package com.jdc.ygn.admin.app.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.jdc.ygn.admin.app.model.CategoryModel;
import com.jdc.ygn.admin.app.model.RestaurantModel;
import com.jdc.ygn.admin.app.model.entity.Category;
import com.jdc.ygn.admin.app.model.entity.Restaurant;
import com.jdc.ygn.admin.app.view.CategoryVO;
import com.jdc.ygn.mvc.AbstractController;

@WebServlet(urlPatterns={"/category", "/category/*"})
public class CategoryController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private CategoryModel cm;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			cm = new CategoryModel(connection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void index() {
		// find category
		List<Category> categories = cm.getAll();
		List<CategoryVO> voList = new ArrayList<CategoryVO>();
		
		try (Connection conn = connection()){
			RestaurantModel rModel = new RestaurantModel(conn);
			for(Category c : categories) {
				List<Restaurant> resList = rModel.findByCategory(c.getId());
				if(null != resList && resList.size() > 0) {
					voList.add(new CategoryVO(c, resList));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request("list", voList);
		
		forward("restaurant/categories");
	}
	
	public void list() {
		List<Category> categories = cm.getAll();
		request("list", categories);
		forward("category/list");
	}

}
