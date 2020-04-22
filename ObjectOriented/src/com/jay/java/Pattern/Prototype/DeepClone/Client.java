package com.jay.java.Pattern.Prototype.DeepClone;

import java.util.Date;

/**
 * 深复制
 * @author jay
 *
 */
public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Date d = new Date(12738L);
		Sheep s1 = new Sheep("jay",d);
		Sheep s2 = (Sheep) s1.clone();
		System.out.println(s1);
		System.out.println(s1.getBirthday());
		d.setTime(1982938729L);
		/**
		 * 两个不同对象，但是他们的值是一样的
		 */
		System.out.println(s1.getBirthday());
		
		
		
		System.out.println(s2.getBirthday());
		System.out.println(s2);
		System.out.println(s1.getSname() == s2.getSname());
		System.out.println(s1.getBirthday() == s2.getBirthday());
	}
}
