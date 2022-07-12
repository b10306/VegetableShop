package com.brian.dao;

import java.util.List;

import com.brian.entity.Order;
import com.brian.entity.OrderItem;

public interface OrderItemDAO {
	void addOrderItem(OrderItem orderItem);
	List<OrderItem> getAllOrderItemsByOrder(Order order);
}
