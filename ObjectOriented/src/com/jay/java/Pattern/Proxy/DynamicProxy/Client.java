package com.jay.java.Pattern.Proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		Star realStar = new RealStar();
		StarHandler handler = new StarHandler(realStar);
		/**
		 * 类加载器,
		 * class[]{Star.class}-接口
		 * handler - InvocationHandler接口,重写Invoke方法，筛选关键方法
		 */
		Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {Star.class}, handler);
		/**
		 * 只要调用代理类
		 * 都调用invoke方法
		 */
		proxy.bookTicket();
		proxy.sing();
	}
}
