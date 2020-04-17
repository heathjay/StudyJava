package com.jay.jave.ref;

public class User {
	private String uName;
	private int id;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String uName, int id) {
		super();
		this.uName = uName;
		this.id = id;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
