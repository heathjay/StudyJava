package com.jay.jave.ref;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 性能检查
 * @author jay
 *
 */

public class TestSpeedSetAccessible {
	public static void Test1() {
		User u = new User();
		long startTime = System.currentTimeMillis();
		
		for(int i = 0;i < 1000000000L;i++) {
			u.getuName();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("normal test:" + (startTime - endTime) + "ms");
	}
	
	public static void Test2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		User u = new User();
		Class clz = Class.forName("com.jay.jave.ref.User");
		Method method =clz.getDeclaredMethod("getuName", null);
		
		long startTime = System.currentTimeMillis();
		
		for(int i = 0;i < 1000000000L;i++) {
			method.invoke(u, null);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("normal test:" + (startTime - endTime) + "ms");
	}
	public static void Test3() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		User u = new User();
		Class clz = Class.forName("com.jay.jave.ref.User");
		Method method =clz.getDeclaredMethod("getuName", null);
		method.setAccessible(true);
		
		long startTime = System.currentTimeMillis();
		
		for(int i = 0;i < 1000000000L;i++) {
			method.invoke(u, null);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("normal test:" + (startTime - endTime) + "ms");
	}
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Test1();
		Test2();
		Test3();
	}
}
