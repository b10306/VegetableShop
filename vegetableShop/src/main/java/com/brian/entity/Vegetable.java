package com.brian.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vegetable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String vegName;
	private int price;
	private int saleCount;
	private int totalCount;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVegName() {
		return vegName;
	}
	public void setVegName(String vegName) {
		this.vegName = vegName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Vegetable(int id, String vegName, int price, int saleCount, int totalCount, String type) {
		super();
		this.id = id;
		this.vegName = vegName;
		this.price = price;
		this.saleCount = saleCount;
		this.totalCount = totalCount;
		this.type = type;
	}
	public Vegetable() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Vegetable [id=" + id + ", vegName=" + vegName + ", price=" + price + ", saleCount=" + saleCount
				+ ", totalCount=" + totalCount + ", type=" + type + "]";
	}
	
	
}
