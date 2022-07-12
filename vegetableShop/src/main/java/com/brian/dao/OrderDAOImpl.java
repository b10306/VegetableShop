package com.brian.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.brian.entity.Order;
import com.brian.entity.User;

@Repository
public class OrderDAOImpl extends BaseDAO implements OrderDAO{

	@Override
	public void addOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(order);
	}

	@Override
	public List<Order> getAllOrdersByUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Order where orderUser = :user", Order.class);
		query.setParameter("user", user);
		List<Order> list = query.getResultList();
		return list;
	}

	@Override
	public Order getOrderById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Order order = session.get(Order.class, id);
		return order;
	}
	
	

}
