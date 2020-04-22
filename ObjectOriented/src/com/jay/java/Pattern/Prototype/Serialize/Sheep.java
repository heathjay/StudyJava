package com.jay.java.Pattern.Prototype.Serialize;

import java.io.Serializable;
import java.util.Date;

public class Sheep implements Cloneable, Serializable{
	private String sname;
	private Date birthday;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		return obj;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Sheep() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sheep(String sname, Date birthday) {
		super();
		this.sname = sname;
		this.birthday = birthday;
	}
	
}
