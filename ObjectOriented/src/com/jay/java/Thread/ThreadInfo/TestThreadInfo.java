package com.jay.java.Thread.ThreadInfo;
/**
 * 线程的基本信息
 * 	- Thread.currentThread 静态方法,写在哪个线程里面就代表当前线程
 * 	- setName/getName
 * 	- isAlive()
 * 
 * 优先级:
 * 	- MAX_PRIORITY 10
 * 	- NORM_PRIORITY 5	默认
 *  - MIN_PRIORITY 1
 *  - setPriority/getPriority
 *  优先级不代表先后顺序，优先级低的仍旧会执行，但是概率降低
 * @author jay
 *
 */
public class TestThreadInfo {
	public static void main(String[] args) throws InterruptedException {
/*		MyThread t1 = new MyThread();
		Thread proxy = new Thread(t1,"name");
		System.out.println(proxy.getName());
		proxy.setName("test");
		System.out.println(proxy.getName());
		System.out.println(Thread.currentThread().getName());
		
		proxy.start();
		System.out.println("启动后对的状态:" + proxy.isAlive());
		Thread.sleep(200);
		t1.stop();
		System.out.println("启动后对的状态:" + proxy.isAlive());*/
		
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		Thread p1 = new Thread(t1,"name");
		Thread p2 = new Thread(t2,"xxx");
		
		
		//设置优先级
		p1.setPriority(Thread.MIN_PRIORITY);
		p2.setPriority(Thread.MAX_PRIORITY);
		p1.start();
		p2.start();
		Thread.sleep(100);
		t1.stop();
		t2.stop();
		
		
	}
}
class MyThread implements Runnable{
	private boolean flag = true;
	private int num = 0;
	@Override
	public void run() {
		while(flag) {
			System.out.println(Thread.currentThread().getName() + num++);
		}
	}
	
	
	public void stop() {
		this.flag = !this.flag;
	}
}