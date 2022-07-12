package com.brian.service;

import java.util.List;

import com.brian.entity.Cart;

public interface CartService {
	void addToCart(int vid, int buyCount, int uid);
	void deleteCart(int id);
	List<Cart> getAllCarts(int uid);
}
