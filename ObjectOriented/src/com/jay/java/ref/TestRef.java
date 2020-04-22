package com.jay.java.ref;
/**
 * 反射
 * @author jay
 *
 */
public class TestRef {
	public static void main(String[] args) throws ClassNotFoundException {
		String str = "abc";
		//.getClass
		Class<?> clz = str.getClass();
		//类.class
		clz = String.class;
		//完整路径+类名
		clz = Class.forName("java.lang.String");
	}
}
