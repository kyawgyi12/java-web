package com.jdc.web.serv.ch4.util;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jdc.web.serv.ch4.Gender;


public class SqlHelper<T> {
	
	private Class<T> type;
	
	public SqlHelper(Class<T> type) {
		this.type = type;
	}
	
	public List<T> getFromResultSet(ResultSet rs) throws SQLException, InstantiationException, IllegalAccessException {
		List<T> list = new ArrayList<>();
		while(rs.next()) {
			Field [] fields = type.getDeclaredFields();
			T obj = type.newInstance();
			for(Field f : fields) {
				if(!"serialVersionUID".equals(f.getName())) {
					f.setAccessible(true);
					Object fieldObj = rs.getObject(f.getName());

					if (f.getName().equals("gender")) {
						fieldObj = Gender.values()[Integer.parseInt(fieldObj.toString())];
					} 

					f.set(obj, fieldObj);
				}
			}
			
			list.add(obj);
		}
		return list;
	}
	
	public Map<String, Object> getMap(T t) throws InstantiationException, IllegalAccessException {
		
		Map<String, Object> map = new HashMap<>();
		Field [] fields = type.getDeclaredFields();

		for(Field f : fields) {
			if(!"serialVersionUID".equals(f.getName())) {
				f.setAccessible(true);
				
				Object fieldObj = f.get(t);
				
				if (f.getName().equals("gender")) {
					fieldObj = ((Gender)fieldObj).ordinal();
				}
				
				// util.Date to sql.Date
				if (f.getName().equals("dob")) {
					fieldObj = new Date(((java.util.Date)fieldObj).getTime());
				}
				
				map.put(f.getName(), fieldObj);
			}
		}

		return map;
	}

}
