package com.jdc.ygn.admin;


import org.junit.Test;

import com.jdc.ygn.admin.app.model.entity.Restaurant;
import com.jdc.ygn.sql.SqlHelper;

public class SqlHelperTest {

	@Test
	public void testGetInsertSql() {
		SqlHelper<Restaurant> helper = new SqlHelper<>(Restaurant.class);
		System.out.println(helper.getInsertSql());
		System.out.println(helper.getDeleteSql());
		System.out.println(helper.getSelectAllSql());
		System.out.println(helper.getUpdateSql());
		System.out.println(helper.getFindByIdSql());
	}

}
