package com.jay.java.TestException;

import java.util.Scanner;

/**
 * 异常处理
 * @author jay
 * checkedException, uncheckedException
 * unchecked - runtimeException, NullPointException
 * 常见异常该怎么办
 * 	1. ArithmeticException
 *  2. NullPointerException  - 对象是空的，对象的方法和属性被调用，（无static）
 *  3. ClassCastException, 多态
 *  4. ArrayIndexOutOfBoundsException ,数组越界
 *  5. NumberFormatException。数字格式异常
 */
public class TestExceptionHandling {
	public static void main(String[] args) {
		//unchecked
		//int i = 1 / 0;
		
		//checked 编译器检查过了,自动捕获
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		int b = 5;
		
		
		//1. ArithmeticException
		if(b != 0) {
			int i = 1 / b;
		}else {
			System.out.println("b is bad number");
		}
		
		
		//2. NullPointerException 
		Computer c = null;
		if(c != null) {
			c.start();
		}
		
		// 3. ClassCastException
//		if(obj instanceof Man) {
//			Man man = (Man) obj;
//		}
		
		// 4. ArrayIndexOutOfBoundsException ,数组越界
//		if(idx <= a.length - 1) {
//			System.out.println(idx);
//		}
		
		//5. NumberFormatException。数字格式异常
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		System.out.println(a);
		String str = "1234ea";
		Integer i = new Integer(str);
	}
}

class Computer{
	 // static void start() {
	 void start() {
		System.out.println("pc is started");
	}
}
