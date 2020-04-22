package com.jay.java.Pattern.Prototype.DeepClone;

import java.util.Date;

public class Sheep implements Cloneable{
	private String sname;
	private Date birthday;
	@Override
	public Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		/**
		 * 实现深复制
		 */
		
		Sheep s = (Sheep)obj;
		s.birthday = (Date) this.birthday.clone();//把属性也进行克隆
		return s;
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
