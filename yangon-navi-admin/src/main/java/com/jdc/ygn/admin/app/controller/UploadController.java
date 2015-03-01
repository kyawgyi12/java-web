package com.jdc.ygn.admin.app.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;

import com.jdc.ygn.admin.app.model.CategoryModel;
import com.jdc.ygn.admin.app.model.entity.Category;
import com.jdc.ygn.admin.app.model.entity.Phone;
import com.jdc.ygn.admin.app.model.entity.Rank;
import com.jdc.ygn.admin.app.model.entity.Restaurant;
import com.jdc.ygn.admin.app.model.entity.RestaurantCategory;
import com.jdc.ygn.admin.app.model.entity.Township;
import com.jdc.ygn.mvc.AbstractController;
import com.jdc.ygn.sql.BaseModel;

@WebServlet(urlPatterns = { "/upload", "/upload/*" })
@MultipartConfig
public class UploadController extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Override
	public void index() {
		forward("upload/index");
	}

	@SuppressWarnings("unchecked")
	public void restaurant() throws IOException, ServletException {

		// get upload file from request
		Part file = file("load-file");

		Map<Long, String> map = new HashMap<>();

		// model add
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				file.getInputStream()))) {
			String line = null;
			Connection conn = connection();
			BaseModel<Restaurant> resModel = new BaseModel<Restaurant>(
					Restaurant.class, conn);
			while (null != (line = br.readLine())) {
				String phone = "";
				String[] strs = line.split("\t");
				Restaurant res = new Restaurant();

				// name
				res.setName(strs[0].trim());

				// address
				res.setAddress(strs[1].trim());

				// township
				String township = strs[2].trim();

				List<Township> townships = (List<Township>) application("townships");
				townships.stream()
						.filter(a -> a.getName().equalsIgnoreCase(township))
						.map(a -> a.getId()).findFirst()
						.ifPresent(a -> res.setTownshipId(a));

				if (res.getTownshipId() == 0) {
					continue;
				}

				// opening
				if (strs.length > 3) {
					res.setOpening(strs[3].trim());
				}

				// creation
				res.setCreation(new Date());

				// modification
				res.setModification(new Date());

				// insert
				resModel.insert(res);

				if (strs.length > 4)
					phone = strs[4];

				map.put(res.getId(), phone);

			}
			
			conn.close();
			
			conn = connection();

			BaseModel<Phone> phoneModel = new BaseModel<Phone>(Phone.class,
					conn);

			for (Long id : map.keySet()) {
				String[] sts = map.get(id).split(",");
				if (sts.length > 0) {
					for (String s : sts) {
						Phone phone = new Phone();
						phone.setPhone(s.trim());
						phone.setRestaurantId(id);
						phoneModel.insert(phone);
					}
				}
			}

			conn.close();
			
			conn = connection();
			BaseModel<Rank> rankModel = new BaseModel<Rank>(Rank.class,
					conn);

			for (Long id : map.keySet()) {
				for (int i = 0; i < 4; i++) {
					Rank rank = new Rank();
					rank.setRank(0);
					rank.setRank_id(i);
					rank.setRestaurant_id(id);

					rankModel.insert(rank);
				}
			}
			
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// redirect to view
		redirect(url("restaurant"));
	}

	public void category() throws IOException, ServletException {
		// get upload file from request
		Part file = file("load-file");

		// model add
		try (Connection conn = connection();
				BufferedReader bf = new BufferedReader(new InputStreamReader(
				file.getInputStream()))) {

			String line = null;
			
			CategoryModel cModel = new CategoryModel(conn);
			
			while (null != (line = bf.readLine())) {
				Category c = new Category();
				c.setName(line.trim());
				cModel.insert(c);
			}
			application("category", cModel.getAll());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// redirect to view
		redirect(url("category/list"));
	}
	
	
	public void rest_category() throws IOException, ServletException {
		// get upload file from request
		Part file = file("load-file");

		// model add
		try (Connection conn = connection();
				BufferedReader bf = new BufferedReader(new InputStreamReader(
				file.getInputStream()))) {

			String line = null;
			
			CategoryModel cModel = new CategoryModel(conn);
			BaseModel<RestaurantCategory> rcModel = new BaseModel<RestaurantCategory>(
					RestaurantCategory.class, conn);
			
			while (null != (line = bf.readLine())) {
				String[] strs = line.split("\t");

				if (strs.length > 2) {
					// find restaurant
					long resId = Long.parseLong(strs[0]);
					
					for(int i=2; i < strs.length; i++) {
						String tmp = strs[i].trim();
						if(null != tmp && !tmp.isEmpty()) {
							// find category
							List<Category> cList = cModel.findByName(tmp);

							if (cList.size() > 0) {
								// add to restaurant_category
								RestaurantCategory rc = new RestaurantCategory();
								rc.setCategoryId(cList.get(0).getId());
								rc.setRestaurantId(resId);
								
								rcModel.insert(rc);
							}
						}
					}

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// redirect to view
		redirect(url("category"));
	}

}
