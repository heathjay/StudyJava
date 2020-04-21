package com.jay.java.Pattern.Singleton;
/**
 * 测试单例
 * 1. 饿汉式
 * - 类加载时进行初始化这个对象static
 * - 线程安全，方法前面不用进行synchronized，类加载器加载类是一个天然的线程安全
 * - 方法没有同步，效率高
 * - 
 * @author jay
 *
 */
public class SingletonDemo {
	
	private static SingletonDemo instance = new SingletonDemo();
	private SingletonDemo() {
		
	}
	
	public static SingletonDemo getInstance() {
		return instance;
	}
}
