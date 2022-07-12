package com.brian.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String orderNo;
	
	@ManyToOne
	@JoinColumn(name = "orderUser")
	private User orderUser;
	
	private int orderMoney;
	
	private int orderStatus;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
	private Set<OrderItem> orderItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public User getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(User orderUser) {
		this.orderUser = orderUser;
	}

	public int getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(int orderMoney) {
		this.orderMoney = orderMoney;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(OrderItem orderItem) {
		if(this.orderItems == null) {
			this.orderItems = new HashSet<>();
		}
		this.orderItems.add(orderItem);
	}

	public Order(int id, String orderNo, User orderUser, int orderMoney, int orderStatus,
			Set<OrderItem> orderItems) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.orderUser = orderUser;
		this.orderMoney = orderMoney;
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNo=" + orderNo + ", orderUser=" + orderUser + ", orderMoney=" + orderMoney
				+ ", orderStatus=" + orderStatus + ", orderItems=" + orderItems + "]";
	}
	
	
}
