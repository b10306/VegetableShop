package com.brian.dao;

import java.util.List;

import com.brian.entity.Vegetable;

public interface VegetableDAO {
	List<Vegetable> getAllVegetables();
	void addVeg(Vegetable vegetable);
	void updateVeg(Vegetable vegetable);
	Vegetable getVegById(int id);
}
