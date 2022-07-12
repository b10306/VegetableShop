package com.brian.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.dao.CartDAO;
import com.brian.dao.VegetableDAO;
import com.brian.entity.Cart;
import com.brian.entity.Vegetable;

@Service
@Transactional
public class CartServiceImpl implements CartService{
	
	@Autowired
	private VegetableDAO vegetableDAO;
	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public void addToCart(int vid, int buyCount, int uid) {
		Cart cart = new Cart();
		Vegetable veg = vegetableDAO.getVegById(vid);
		cart.setBuyCount(buyCount);
		cart.setUid(uid);
		cart.setVeg(veg);
		veg.setSaleCount(veg.getSaleCount() + cart.getBuyCount());
		veg.setTotalCount(veg.getTotalCount() - cart.getBuyCount());
		vegetableDAO.updateVeg(veg);
		try {
			cartDAO.updateCart(cart);
		} catch (Exception e) {
			cartDAO.addCart(cart);
		}
	}

	@Override
	public void deleteCart(int id) {
		Cart cart = cartDAO.getCartById(id);
		Vegetable veg = cart.getVeg();
		veg.setSaleCount(veg.getSaleCount() - cart.getBuyCount());
		veg.setTotalCount(veg.getTotalCount() + cart.getBuyCount());
		vegetableDAO.updateVeg(veg);
		cartDAO.deleteCartById(cart.getId());
	}

	@Override
	public List<Cart> getAllCarts(int uid) {
		List<Cart> list = cartDAO.getCartsByUid(uid);
		return list;
	}
	
	
}
