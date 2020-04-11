package com.jay.java.TestCommonsCollections;



public class Goods {
	private String name;
	private double price;
	private boolean discount;
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(String name, double price, boolean discount) {
		super();
		this.name = name;
		this.price = price;
		this.discount = discount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isDiscount() {
		return discount;
	}
	public void setDiscount(boolean discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + ", discount=" + discount + "]";
	}
	
}
