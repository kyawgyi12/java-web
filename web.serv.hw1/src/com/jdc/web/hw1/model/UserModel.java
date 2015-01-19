package com.jdc.web.hw1.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.jdc.web.hw1.model.entity.User;

public class UserModel extends Model<User> {

	private static final long serialVersionUID = 1L;
	
	
	public UserModel(String path) {
		super();
		try {
			addAll(this.getList(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<User> getList(String path) throws IOException {
		List<String> list = Files.readAllLines(Paths.get(path));
		return list.stream().map(a -> {
			String[] array = a.split(",");
			User item = new User();
			item.setName(array[0]);
			item.setPass(array[1]);
			return item;
		}).collect(Collectors.toList());
	}

	@Override
	public synchronized User findById(int id) {
		return getAll().stream().filter(a -> a.getId() == id).findAny().orElse(null);
	}

}
