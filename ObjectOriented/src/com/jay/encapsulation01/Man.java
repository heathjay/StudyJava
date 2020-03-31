package com.jay.encapsulation01;
/**
 * 
 * @author jay
 * private
 * default
 * protected
 * public 
 *
 */
public class Man {
	private String name;
	private int id;
	public static int cc;
	public static final int MAX_SPEED = 120;
	private boolean Man;
	/**
	 * @return the man
	 */
	public boolean isMan() {
		return Man;
	}

	/**
	 * @param man the man to set
	 */
	public void setMan(boolean man) {
		Man = man;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName() {
		this.name = name;
	}
}
