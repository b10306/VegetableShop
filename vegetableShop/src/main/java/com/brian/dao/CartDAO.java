package com.brian.dao;

import java.util.List;

import com.brian.entity.Cart;
import com.brian.entity.Vegetable;

public interface CartDAO {
	void addCart(Cart cart);
	void updateCart(Cart cart) throws Exception;
	void deleteCartById(int id);
	void deleteCartsByUid(int uid);
	List<Cart> getCartsByUid(int uid);
	Cart getCartById(int id);
}
