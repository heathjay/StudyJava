package com.jay.java.Sort;
/**
 * java.util.
 * @author jay
 * 这个类不实现任何接口
 */
public class Good {
	private String name;
	private double price;
	private int fav;

	public Good(String name, int price, int fav) {
		super();
		this.name = name;
		this.price = price;
		this.fav = fav;
	}
	public Good(String name, double price, int fav) {
		super();
		this.name = name;
		this.price = price;
		this.fav = fav;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the fav
	 */
	public int getFav() {
		return fav;
	}
	/**
	 * @param fav the fav to set
	 */
	public void setFav(int fav) {
		this.fav = fav;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "name:" + name + "price:" + price + "fav:" + fav +"\n";
	}
	
}
