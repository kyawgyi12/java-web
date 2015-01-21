package com.jdc.web.util.tag.factory;

import java.lang.reflect.Field;
import java.util.List;

import com.jdc.web.util.tag.BasicTag;
import com.jdc.web.util.tag.Tag;

public class TableTagFactory implements AbstractTagFactory {

	private Tag tag;
	private String styleClass;

	@Override
	public Tag create() {
		return tag;
	}

	public TableTagFactory() {
		tag = TagFactory.create(new BasicTagFactory("div",
				"There is no Data for table.")
				.styleClass("alert alert-warning"));
	}

	public <T> TableTagFactory addAllData(List<T> list, Class<T> type) {
		try {
			if (null != list && list.size() > 0) {
				tag = new Table();
				if (null != styleClass) {
					tag.addAttribute("class", this.styleClass);
				}

				// header row
				Field[] fs = type.getDeclaredFields();
				Tag hTr = TagFactory.create(new BasicTagFactory("tr"));

				for (Field f : fs) {
					f.setAccessible(true);
					if (!"serialVersionUID".equals(f.getName())) {
						hTr.addChilds(TagFactory.create(new BasicTagFactory(
								"td", f.getName().toUpperCase())));
					}
				}
				
				tag.addChilds(hTr);

				// body rows
				for (T t : list) {
					Tag tr = TagFactory.create(new BasicTagFactory("tr"));
					for (Field f : fs) {
						f.setAccessible(true);
						if (!"serialVersionUID".equals(f.getName())) {
							Object value = f.get(t);
							tr.addChilds(TagFactory
									.create(new BasicTagFactory("td", value.toString())));
						}
					}
					
					tag.addChilds(tr);
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public AbstractTagFactory styleClass(String styleClass) {
		this.styleClass = styleClass;
		tag.addAttribute("class", styleClass);
		return this;
	}

	public static class Table extends BasicTag {

		public Table() {
			super("table");
		}

	}

}
