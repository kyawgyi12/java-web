package com.jdc.web.hw1.model;

import java.util.List;
import java.util.stream.Collectors;

import com.jdc.web.hw1.model.entity.SellItem;
import com.jdc.web.hw1.model.entity.User;

public class SellItemModel extends Model<SellItem> {

	private static final long serialVersionUID = 1L;

	@Override
	public synchronized SellItem findById(int id) {
		return getAll().stream().filter(a -> a.getId() == id).findAny().get();
	}

	public synchronized List<SellItem> findByUser(User user) {
		return getAll().stream().filter(s -> s.getUser().equals(user))
				.collect(Collectors.toList());
	}

}
