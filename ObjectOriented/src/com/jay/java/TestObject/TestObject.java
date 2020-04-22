package com.jay.java.TestObject;
/**
 * Object 包
 * @author jay
 *
 */
public class TestObject {
	public static void main(String[] args) {
		Object obj = new Object();	
		Object obj1 = new Object();
		System.out.println(obj.toString());
		System.out.println(obj1.toString());
		System.out.println(obj == obj1);
		System.out.println(obj.equals(obj1));
		
		Mobile m = new Mobile();
		System.out.println(m.toString());
		
	}
}
