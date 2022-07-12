package com.brian.dao;

import java.util.List;

import com.brian.entity.Order;
import com.brian.entity.User;

public interface OrderDAO {
	void addOrder(Order order);
	List<Order> getAllOrdersByUser(User user);
	Order getOrderById(int id);
}
