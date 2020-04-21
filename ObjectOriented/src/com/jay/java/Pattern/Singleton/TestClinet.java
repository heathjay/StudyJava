package com.jay.java.Pattern.Singleton;

public class TestClinet {
	public static void main(String[] args) {
		SingletonDemo s1 = SingletonDemo.getInstance();
		SingletonDemo s2 = SingletonDemo.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		
		
		System.out.println(SingletonEnum.INSTANCE==SingletonEnum.INSTANCE);
		
	}
}
