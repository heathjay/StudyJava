package com.jay.java.DeepHashMap;
/**
 * javabean
 * @author jay
 *
 */
public class Letter {
	private String name;
	private int count;
	public Letter() {
		
	}
	public Letter(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	public Letter(String name) {
		super();
		this.name = name;
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
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	
}
