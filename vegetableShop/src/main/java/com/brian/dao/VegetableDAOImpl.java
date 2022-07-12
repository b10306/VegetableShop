package com.brian.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.brian.entity.Vegetable;

@Repository
public class VegetableDAOImpl extends BaseDAO implements VegetableDAO{

	@Override
	public List<Vegetable> getAllVegetables() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Vegetable", Vegetable.class);
		List<Vegetable> list = query.getResultList();
		return list;
	}

	@Override
	public void updateVeg(Vegetable vegetable) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(session);
		Vegetable newVeg = getVegById(vegetable.getId());
		newVeg.setPrice(vegetable.getPrice());
		newVeg.setSaleCount(vegetable.getSaleCount());
		newVeg.setTotalCount(vegetable.getTotalCount());
		newVeg.setType(vegetable.getType());
		newVeg.setVegName(vegetable.getVegName());
		session.persist(newVeg);
	}

	@Override
	public Vegetable getVegById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Vegetable veg = session.get(Vegetable.class, id); 
		return veg;
	}

	@Override
	public void addVeg(Vegetable vegetable) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(vegetable);
	}

}