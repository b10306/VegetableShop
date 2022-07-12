package com.brian.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.dao.CartDAO;
import com.brian.dao.OrderDAO;
import com.brian.dao.OrderItemDAO;
import com.brian.dao.UserDAO;
import com.brian.entity.Cart;
import com.brian.entity.Order;
import com.brian.entity.OrderItem;
import com.brian.entity.User;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private OrderItemDAO orderItemDAO;
	
	@Override
	public void addToOrder(int uid) {
		User user = userDAO.getUserById(uid);
		List<Cart> cartList = cartDAO.getCartsByUid(uid);
		Order order = new Order();
		int orderMoney = 0;
		for(Cart cart : cartList) {
			OrderItem orderItem = new OrderItem();
			orderItem.setBuyCount(cart.getBuyCount());
			orderItem.setVeg(cart.getVeg());
			orderItem.setOrder(order);
			orderMoney += cart.getVeg().getPrice() * cart.getBuyCount();
		}
		order.setOrderNo("測試");
		order.setOrderMoney(orderMoney);
		order.setOrderUser(user);
		orderDAO.addOrder(order);
		cartDAO.deleteCartsByUid(uid);
	}

	@Override
	public List<Order> getUserOrders(int uid) {
		User user = userDAO.getUserById(uid);
		List<Order> list = orderDAO.getAllOrdersByUser(user);
		return list;
	}

	@Override
	public List<OrderItem> getOrderItems(int orderId) {
		Order order = orderDAO.getOrderById(orderId);
		List<OrderItem> list = orderItemDAO.getAllOrderItemsByOrder(order);
		return list;
	}

}
