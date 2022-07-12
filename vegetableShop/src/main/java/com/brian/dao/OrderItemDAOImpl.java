package com.brian.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.brian.entity.Order;
import com.brian.entity.OrderItem;

@Repository
public class OrderItemDAOImpl extends BaseDAO implements OrderItemDAO{

	@Override
	public void addOrderItem(OrderItem orderItem) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(orderItem);
	}

	@Override
	public List<OrderItem> getAllOrderItemsByOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from OrderItem where order = :order", OrderItem.class);
		query.setParameter("order", order);
		List<OrderItem> list = query.getResultList();
		return list;
	}

}
