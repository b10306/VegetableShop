package com.brian.service;

import java.util.List;

import com.brian.entity.Order;
import com.brian.entity.OrderItem;

public interface OrderService {
	void addToOrder(int uid);
	List<Order> getUserOrders(int uid);
	List<OrderItem> getOrderItems(int orderId);
}
