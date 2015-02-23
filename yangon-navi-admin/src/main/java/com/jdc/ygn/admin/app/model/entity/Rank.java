package com.jdc.ygn.admin.app.model.entity;

public class Rank {
	
	private int rank_id;
	private long restaurant_id;
	private long rank;

	public int getRank_id() {
		return rank_id;
	}
	public void setRank_id(int rank_id) {
		this.rank_id = rank_id;
	}
	public long getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(long restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public long getRank() {
		return rank;
	}
	public void setRank(long rank) {
		this.rank = rank;
	}

}
