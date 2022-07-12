package com.brian.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brian.entity.Order;
import com.brian.entity.OrderItem;
import com.brian.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String addOrder(HttpSession session) {
		int uid = (int) session.getAttribute("UID");
		orderService.addToOrder(uid);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String getUserOrders(Model model, HttpSession session) {
		int uid = (int) session.getAttribute("UID");
		List<Order> orderList = orderService.getUserOrders(uid);
		model.addAttribute("orderList", orderList);
		return "order";
	}
	
	@RequestMapping(value = "/orderItems/{id}", method = RequestMethod.GET)
	public String getOrderItems(@PathVariable("id") int id, Model model) {
		List<OrderItem> orderItemsList = orderService.getOrderItems(id);
		model.addAttribute("orderItemsList", orderItemsList);
		return "orderItems";
	}
	
}
