package com.jdc.ygn.mvc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;

import com.jdc.ygn.admin.app.model.entity.Photo;
import com.jdc.ygn.sql.BaseModel;

@WebServlet
public class ImageWriter extends GenericServlet {

	private static final long serialVersionUID = 1L;

	private BaseModel<Photo> photoModel;

	@Resource(name = "jdbc/yangon_navi")
	private DataSource ds;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			photoModel = new BaseModel<Photo>(Photo.class, ds.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		String id = req.getParameter("photo");
		if (null != id) {
			int intId = Integer.parseInt(id);
			Photo photo = photoModel.findById(intId);
			if (null != photo) {
				try (BufferedInputStream bi = new BufferedInputStream(
						new ByteArrayInputStream(photo.getPhoto()));
						BufferedOutputStream bo = new BufferedOutputStream(
								res.getOutputStream())) {
					int ch = 0;
					while ((ch = bi.read()) == -1) {
						bo.write(ch);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
