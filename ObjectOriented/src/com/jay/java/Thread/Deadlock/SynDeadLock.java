package com.jay.java.Thread.Deadlock;
/**
 * 死锁问题
 * - 生产者消费者模式
 * @author jay
 *
 */
public class SynDeadLock {
	public static void main(String[] args) {
		Object g = new Object();
		Object m = new Object();
		Test t1 = new Test(g,m);
		Test2 t2 = new Test2(g,m);
		Thread proxy = new Thread(t1);
		Thread proxy2 = new Thread(t2);
		proxy.start();
		proxy2.start();
		
	}
}

class Test implements Runnable{
	Object goods ;
	Object money ;
	@Override
	public void run() {
		while(true) {
			try {
				test();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Test(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}

	public void test() throws InterruptedException {
		synchronized(goods) {
			Thread.sleep(500);
			synchronized(money) {
				
			}
		}
		System.out.println("一手给钱");
	}
	
}

class Test2 implements Runnable{
	Object goods;
	Object money ;
	@Override
	public void run() {
		while(true) {
			try {
				test();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Test2(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}

	public void test() throws InterruptedException {
		synchronized(money) {
			Thread.sleep(500);
			synchronized(goods) {
				
			}
		}
		System.out.println("一钱");
	}
	
}