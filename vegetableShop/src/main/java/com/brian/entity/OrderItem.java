package com.brian.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "vegId")
	private Vegetable veg;
	private int buyCount;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vegetable getVeg() {
		return veg;
	}

	public void setVeg(Vegetable veg) {
		this.veg = veg;
	}

	public int getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
		order.setOrderItems(this);
	}

	public OrderItem(int id, Vegetable veg, int buyCount, Order order) {
		super();
		this.id = id;
		this.veg = veg;
		this.buyCount = buyCount;
		this.order = order;
	}

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", veg=" + veg + ", buyCount=" + buyCount + ", order=" + order + "]";
	}
	
	
}
