package com.brian.service;

import java.util.List;

import com.brian.entity.Vegetable;

public interface VegetableService {
	List<Vegetable> getAllVegetables();
	void updateVeg(Vegetable veg);
	Vegetable getVeg(int vegId);
}
