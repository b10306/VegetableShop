package com.brian.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.dao.VegetableDAO;
import com.brian.entity.Vegetable;

@Service
@Transactional
public class VegetableServiceImpl implements VegetableService{

	@Autowired
	private VegetableDAO vegetableDAO;
	
	@Override
	public List<Vegetable> getAllVegetables() {
		List<Vegetable> list = vegetableDAO.getAllVegetables();
		return list;
	}

	@Override
	public void updateVeg(Vegetable veg) {
		if(veg.getId() == 0) {
			vegetableDAO.addVeg(veg);
		}else {
			vegetableDAO.updateVeg(veg);
		}
		
	}

	@Override
	public Vegetable getVeg(int vegId) {
		Vegetable veg = vegetableDAO.getVegById(vegId);
		return veg;
	}


}
