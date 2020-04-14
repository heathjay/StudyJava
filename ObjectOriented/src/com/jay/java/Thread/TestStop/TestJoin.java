package com.jay.java.Thread.TestStop;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * join:
 * 	合并线程- 等待线程终止，
 * 	阻塞别人
 * - 新生状态
 * 	- 	Thread x = new Thread(t);
 * 
 * yield ：让出cpu的调度
 * 	- 自己线程进行暂定，静态方法
 * 
 * sleep：指定毫秒数
 * - 每一个对象都有一把锁,资源的互斥锁，sleep不会释放资源，与时间相关，数数，倒计时
 * - 模拟网络延时
 * 		- 可能会出现不准确，并发问题
 * @author jay
 *
 */
public class TestJoin extends Thread{
	public static void main(String[] args) throws InterruptedException {
		/*TestJoin t = new TestJoin();
		Thread x = new Thread(t);	//新生状态
		t.start();*/	//就绪
		//cpu调度就进入运行
		/*for(int i = 0;i<100;i++) {
			if(50 == i) {
				x.join();	// main阻塞
			}
			System.out.println("main...."+i);
		}*/
		/*
		for(int i = 0;i<1000;i++) {
			if(i % 20 == 0) {
				Thread.yield();//暂停main线程
			}
			System.out.println("main...."+i);
		}*/
		
		//sleep
		//1.模拟倒计时
		/*int num = 10;
		while(true) {
			System.out.println(num--);
			Thread.sleep(1000);
			if(num<=0) {
				break;
			}
		}*/
		//2.倒计时
		/*Date endTime = new Date(System.currentTimeMillis() + 10 *1000);
		long end = endTime.getTime();
		while(true) {
			//输出
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			//构建下一秒时间
			endTime = new Date(endTime.getTime()-1000);
			//等待一秒
			Thread.sleep(1000);
			if(end-10000>endTime.getTime()) {
				break;
			}
		}*/
		
		/*long end = (new Date(System.currentTimeMillis() + 10*1000)).getTime();
		
		while(true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(System.currentTimeMillis()));
			Thread.sleep(1000);
			if(end <= (new Date(System.currentTimeMillis()).getTime())) {
				break;
			}
		}*/
		
		//3.模拟网络延时
		
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

	@Override
	public void run() {
		for(int i = 0;i<1000;i++) {
			System.out.println("join...." + i);
		}
	}
	
}
class Web12306 implements Runnable{
	private int num = 50;
	@Override
	public void run() {
		while(true) {
			if(num < 10) {
				break;
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
	}
	
}