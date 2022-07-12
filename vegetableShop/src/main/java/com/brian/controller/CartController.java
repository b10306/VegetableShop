package com.brian.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brian.entity.Cart;
import com.brian.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public String addToCart(int vid, int buyCount, HttpSession session) {
		int uid = (Integer)session.getAttribute("UID");
		cartService.addToCart(vid, buyCount, uid);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String getCarts(Model model, HttpSession session) {
		int uid = (int) session.getAttribute("UID");
		List<Cart> cartList = cartService.getAllCarts(uid);
		model.addAttribute("cartList", cartList);
		return "cart";
	}
	
	@RequestMapping(value = "/cart/{id}", method = RequestMethod.DELETE)
	public String deleteCart(@PathVariable("id") int id) {
		cartService.deleteCart(id);
		return "redirect:/cart";
	}
}
