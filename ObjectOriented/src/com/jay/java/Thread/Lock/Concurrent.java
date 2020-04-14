package com.jay.java.Thread.Lock;



/**
 * 同步（并发）多个线程访问同一个资源
 * - 确保这份资源安全
 * - 对线程加入同步，线程安全 HashTable
 * - synchronized 一个锁 线程安全的方法前面
 * - 效率低
 * 1. 同步块
 * 	- 锁定范围
 * 	- 锁定对象
 * 	-
 * synchronized(只能是引用类型| this｜类.class){
 * 
 * }
 * 2. 同步方法
 * 	- public synchronized void test(){}
 * @author jay
 *
 */
public class Concurrent {
	public static void main(String[] args) {
		//真实
				Web12306 web = new Web12306();
				//代理
				Thread t1 = new Thread(web,"1");
				Thread t2 = new Thread(web,"2");
				Thread t3 = new Thread(web,"3");
				
				t1.start();
				t2.start();
				t3.start();
	}
}
class Web12306 implements Runnable{
	private int num = 50;
	private boolean flag = true;
	@Override
	public void run() {
		while(flag) {
			/*//线程不安全
			test01();*/
			test06();
		}
	}
	
	public void test01() {
		if(num <=0) {
			flag = false;
		}
		//共享num会出现并发问题
		//确定资源的安全性
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ "抢到了"+ num --);
	}// a-1 , b - 0, c - -1
	
	

	public synchronized void test02() {
		if(num <=0) {
			flag = false;
			return;
		}
		//共享num会出现并发问题
		//确定资源的安全性
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ "抢到了"+ num --);
	}// a-1 , b - 0, c - -1
	/**
	 * 同步块
	 */
	public  void test03() {
		synchronized(this) {
			if(num <=0) {
				flag = false;
				return;
			}
			//共享num会出现并发问题
			//确定资源的安全性
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+ "抢到了"+ num --);
		}
		
	}// a-1 , b - 0, c - -1
	
	/**
	 * 锁定范围不正确
	 */
	public  void test04() {
		synchronized(this) {
			if(num < 10) {
				flag = false;
				return;
			}
		}
			//共享num会出现并发问题
			//确定资源的安全性
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+ "抢到了"+ num --);
		
		
	}// a-1 , b - 0, c - -1
	
	/**
	 * 锁定资源不正确
	 * 倾向于锁定对象
	 * 对象包括flag等信息
	 * 
	 */
	public  void test05() {
		synchronized(((Integer)num)) {
			if(num < 10) {
				flag = false;
				return;
			}
		
			//共享num会出现并发问题
			//确定资源的安全性
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+ "抢到了"+ num --);
		}
		
	}// a-1 , b - 0, c - -1
	
	public  void test06() {
		
			if(num < 0) {
				flag = false;
				return;
			}
		synchronized(((Integer)num)) {
			//共享num会出现并发问题
			//确定资源的安全性
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+ "抢到了"+ num --);
		}
		
	}// a-1 , b - 0, c - -1
	
}
