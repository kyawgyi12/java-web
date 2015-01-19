package com.jdc.web.hw1.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.jdc.web.hw1.model.entity.Item;

public class ItemModel extends Model<Item> {

	private static final long serialVersionUID = 1L;

	public ItemModel(String realPath) {
		super();
		try {
			addAll(this.getList(realPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Item> getList(String is) throws IOException {
		List<String> list = Files.readAllLines(Paths.get(is));
		return list.stream().map(a -> {
			String[] array = a.split(",");
			Item item = new Item();
			item.setName(array[0]);
			item.setPrice(Integer.parseInt(array[1]));
			return item;
		}).collect(Collectors.toList());
	}

	@Override
	public synchronized Item findById(int id) {
		return getAll().stream().filter(a -> a.getId() == id).findAny().orElse(null);
	}

}
