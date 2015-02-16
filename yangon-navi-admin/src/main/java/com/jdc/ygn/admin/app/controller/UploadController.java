package com.jdc.ygn.admin.app.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;

import com.jdc.ygn.admin.app.model.entity.Phone;
import com.jdc.ygn.admin.app.model.entity.Restaurant;
import com.jdc.ygn.admin.app.model.entity.Township;
import com.jdc.ygn.mvc.AbstractController;
import com.jdc.ygn.sql.BaseModel;

@WebServlet({ "/upload", "/upload/*" })
@MultipartConfig
public class UploadController extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Override
	public void index() {
		forward("upload/index");
	}

	public void restaurant() throws IOException, ServletException {
		// get upload file from request
		Part file = file("load-file");
		
		// model add
		try(BufferedReader br = 
				new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line = null;
			BaseModel<Restaurant> resModel = new BaseModel<Restaurant>(Restaurant.class, connection());
			while(null != (line = br.readLine())) {
				String [] strs = line.split("\t");
				Restaurant res = new Restaurant();
				
				// name
				res.setName(strs[0].trim());
				
				// address
				res.setAddress(strs[1].trim());
				
				// township
				String township = strs[2].trim();
				@SuppressWarnings("unchecked")
				List<Township> townships = (List<Township>) application("townships");
				townships.stream()
					.filter(a -> a.getName().equalsIgnoreCase(township))
					.map(a -> a.getId()).findFirst()
					.ifPresent(a -> res.setTownshipId(a));
				
				// creation
				res.setCreation(new Date());
				
				// modification
				res.setModification(new Date());
				
				// insert
				Restaurant newtRes = resModel.insert(res);
				
				// restaurant phone
				if(strs.length > 3) {
					String strPhones = strs[3];
					if(null != strPhones && !strPhones.isEmpty()) {
						this.addRestaurantPhones(newtRes, strPhones.split(","));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// redirect to view
		redirect(url("restaurant"));
	}

	public void category() {
		// get upload file from request
		
		
		// model add
		
		// redirect to view
		redirect(url("upload/categories"));
	}
	
	public void categories() {
		// get data from model
		
		// load view
		forward("upload/categories");
	}
	
	private void addRestaurantPhones(Restaurant r, String[] phones) throws SQLException {
		BaseModel<Phone> phoneModel = new BaseModel<Phone>(Phone.class, connection());
		for(String p : phones) {
			Phone phone = new Phone();
			phone.setPhone(p.trim());
			phone.setRestaurantId(r.getId());
			phoneModel.insert(phone);
		}
	}

}
