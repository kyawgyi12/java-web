package com.jdc.ygn.admin.app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;

import com.jdc.ygn.admin.app.model.MenuModel;
import com.jdc.ygn.admin.app.model.PhotoModel;
import com.jdc.ygn.admin.app.model.entity.Menu;
import com.jdc.ygn.admin.app.model.entity.Photo;
import com.jdc.ygn.mvc.AbstractController;
import com.jdc.ygn.sql.PhotoType;

@WebServlet(urlPatterns={"/menu", "/menu/*"})
@MultipartConfig
public class MenuController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private MenuModel menuModel;
	private PhotoModel photoModel;
	
	@Override
	public void init() throws ServletException {
		try {
			super.init();
			menuModel = new MenuModel(connection());
			photoModel = new PhotoModel(connection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void index() {

		
	}
	
	public void add() throws IOException, ServletException {
		String restIdStr = param("id");

		Part photoFile = file("photo");

		if(null != restIdStr) {
			
			Menu menu = new Menu();
			menu.setRestaurantId(Long.parseLong(restIdStr));
			menu.setName(param("name"));
			menu.setPrice(Long.parseLong(param("price")));

			if(null != photoFile) {
				Photo photo = new Photo();
				
				photo.setRestaurantId(Long.parseLong(restIdStr));
				photo.setType(PhotoType.Menu);
				photo.setPhoto(getFileName(photo.getRestaurantId(), photo.getName()));
				
				// write photo to upload folder
				Path path = Paths.get(getServletContext().getRealPath("/upload_data"), "menu", photo.getPhoto());
				Files.copy(photoFile.getInputStream(), path);
				
				photo.setName(menu.getName());
				
				photo = photoModel.insert(photo);
				menu.setPhotoId(photo.getId());
			}
			
			menuModel.insert(menu);
		}
		
		redirect(url("restaurant/details?id=" + restIdStr));

	}
	
	private String getFileName(long restaurantId, String menu) {
		// restaurant (###0) _ menu _ time . extension (PNG)
		DecimalFormat restId = new DecimalFormat("00000");
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return String.format("%s_%s_%s.png", restId.format(restaurantId), menu, df.format(new Date()));
	}

}
