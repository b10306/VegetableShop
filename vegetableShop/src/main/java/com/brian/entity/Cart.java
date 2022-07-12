package com.brian.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "vegId")
	private Vegetable veg;
	
	private int buyCount;
	private int uid;
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
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}

	public Cart(int id, Vegetable veg, int buyCount, int uid) {
		super();
		this.id = id;
		this.veg = veg;
		this.buyCount = buyCount;
		this.uid = uid;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", veg=" + veg + ", buyCount=" + buyCount + ", uid=" + uid + "]";
	}

	
}
