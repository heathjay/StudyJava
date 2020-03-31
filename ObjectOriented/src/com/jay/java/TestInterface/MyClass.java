package com.jay.java.TestInterface;

public class MyClass implements MyInterface{

	@Override
	public void test01() {
		// TODO Auto-generated method stub

		System.out.println("MyClass.test01");
	}

	@Override
	public int test02(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("MyClass.test02");
		return a+b;
	}
	
}
