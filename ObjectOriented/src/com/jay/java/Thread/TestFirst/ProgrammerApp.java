package com.jay.java.Thread.TestFirst;
/**
 * 
 * 
 * - 推荐使用Runnable创建线程
 * 	- 避免单继承的局限性
 * 	- 便于共享资源 - 模拟购票
 * 2.2 Runnable
 * - 1. 创建真实角色
 * - 2. 创建代理角色 + 对真实角色的引用
 * - 3. 调用start方法
 * @author jay
 *
 */
public class ProgrammerApp {
	
	public static void main(String[] args) {
		//1.真实角色
			//面向接口
		Runnable pro = new Programmer();
		//2.创建代理类
		Thread proxy = new Thread(pro);
		//调用方法
		proxy.start();
		
		
		for(int i = 0; i < 20 ;i++) {
			System.out.println("main");
		}
		
		
		Runnable web = new Web12306();
		Thread t1 = new Thread(web,"xx");
		Thread t2 = new Thread(web,"xxx");
		Thread t3 = new Thread(web,"xxxx");
		Thread t4 = new Thread(web,"xxxxx");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
