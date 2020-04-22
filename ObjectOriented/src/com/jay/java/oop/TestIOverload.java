package com.jay.java.oop;

public class TestIOverload {
	public static void main(String args[]) {
		myMath m = new myMath();
		int result = m.add(4,5);
		System.out.println(result);
		result = m.add(4,5,8);
		System.out.println(result);
	}
}
class myMath{
	public int add(int a, int b, int c) {
		return a + b + c;
	}
	
	public int add(int a, int b) {
		return a + b;
	}
}