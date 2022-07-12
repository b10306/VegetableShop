package com.brian.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.brian.entity.Cart;
import com.brian.entity.Vegetable;

@Repository
public class CartDAOImpl extends BaseDAO implements CartDAO{

	@Override
	public void addCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(session);
		session.persist(cart);
	}

	@Override
	public List<Cart> getCartsByUid(int uid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Cart where uid = :uid", Cart.class);
		query.setParameter("uid", uid);
		List<Cart> list = query.getResultList();
		return list;
	}

	@Override
	public void updateCart(Cart cart) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Cart newCart = getCartByUidAndVeg(cart.getUid(), cart.getVeg());
		newCart.setBuyCount(newCart.getBuyCount() + cart.getBuyCount());
		session.persist(newCart);
	}

	private Cart getCartByUidAndVeg(int uid, Vegetable veg) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Cart where uid = :uid and veg = :veg", Cart.class);
		query.setParameter("uid", uid);
		query.setParameter("veg", veg);
		Cart cart = (Cart) query.getSingleResult();
		return cart;
	}

	@Override
	public void deleteCartById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Cart cart = getCartById(id);
		session.delete(cart);
	}

	@Override
	public Cart getCartById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Cart cart = session.get(Cart.class, id);
		return cart;
	}

	@Override
	public void deleteCartsByUid(int uid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Cart where uid = :uid");
		query.setParameter("uid", uid);
		query.executeUpdate();
	}


}
