package com.java01;


public class TestIf {
	public static void main(String[] args) {
		double b = Math.random();//[0,1)
		int e = 1 + (int)(b * 5);
		System.out.println(e);
		//作用域
		//switch 可以 byte,char,short,string，int
		//JDK7 之前 int
		if(e > 3) {
			System.out.println("great");
		}else {
			System.out.println("small");
		}
	}
}
