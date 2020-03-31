package com.jay.java.Array;
/**
 * 
 * @author jay
 * 1.默认初始化
 * 2.动态初始化
 */
public class Test02 {
	public static void main(String args[]) {
		//声明和创建
		int[] a = new int[4];
		//1. 动态
		for(int i=0; i < a.length; i++) {
			a[i] = i * 100;
		}
		
		//2.静态
		int[] c = {11,1,1,1,2,3};
		Car[] cars= {};
		Car[] cc = {
						new Car("奔驰"), 
						new Car("dudu")
					};
		
	}
}
