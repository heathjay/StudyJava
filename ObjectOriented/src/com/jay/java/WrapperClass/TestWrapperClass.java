package com.jay.java.WrapperClass;
/**
 * 
 * @author jay
 * 包装类wrapperClass
 * byte - Byte
 * boolean -Boolean
 * short - Short
 * char - Character
 * int - Integer
 * long - Long
 * float - Float
 * double - Double
 *
 */
public class TestWrapperClass {
	public static void main(String[] args) {
		Integer i = new Integer(11);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toHexString(i));
		//string ->object
		Integer i2 = Integer.parseInt("234");
		System.out.println(i2.intValue());
		String str = 234 + "";
		System.out.println(str);
		
		System.out.println(Integer.max(11,	21));
		
	}
}
