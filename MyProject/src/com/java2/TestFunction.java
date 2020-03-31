package com.java2;


/**
 * @author jay
 *
 */


public class TestFunction {
	public static int add(int a, int b) {
		return a+b;
	}
	/**
	 * 
	 * @author jay
	 * @param a maxnum
	 * @return result
	 */
	public static int Recursive(int a) {
		if(a == 1) {
			return 1;
		}else {
			
			return a * Recursive(a-1);
		}
	}
	public static void main(String[] args) {
		System.out.println(add(1,2));
		System.out.println(Recursive(5));
	}
}
