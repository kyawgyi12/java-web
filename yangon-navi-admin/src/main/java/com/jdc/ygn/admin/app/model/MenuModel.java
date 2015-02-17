package com.jdc.ygn.admin.app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.jdc.ygn.admin.app.model.entity.Menu;
import com.jdc.ygn.admin.app.model.entity.Photo;
import com.jdc.ygn.admin.app.view.MenuVO;
import com.jdc.ygn.sql.BaseModel;

public class MenuModel extends BaseModel<Menu> {
	
	private final BaseModel<Photo> photoModel;
	private final Function<Menu, MenuVO> converter;

	public MenuModel(Connection conn) {
		super(Menu.class, conn);
		photoModel = new BaseModel<Photo>(Photo.class, conn);
		converter = a -> {
			MenuVO vo = new MenuVO();
			vo.setMenu(a);
			vo.setPhoto(photoModel.findById(a.getId()));
			return vo;
		};
	}
	
	public MenuVO getViewObjectById(long id) {

		Menu menu = findById(id);
		
		if(null != menu) {
			return converter.apply(menu);
		}
		
		return null;
	}
	
	public List<MenuVO> findByRestaurant(long restaurantId) {
		
		String sql = "select * from menu where restaurant_id = ?";
		
		try(PreparedStatement stmt = connection().prepareStatement(sql)) {
			stmt.setLong(1, restaurantId);
			
			ResultSet rs = stmt.executeQuery();
			List<Menu> list = helper().getObjects(rs);
			
			return list.stream().map(converter).collect(Collectors.toList());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
