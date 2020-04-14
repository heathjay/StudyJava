package com.jay.java.Thread.TestFirst;
/**
 * 方便共享资源
 * @author jay
 *
 */
public class Web12306 implements Runnable{
	private int num = 50;
	@Override
	public void run() {
		while(true) {
			if(num < 10) {
				break;
			}
			
			System.out.println(Thread.currentThread().getName()+ "抢到了"+ num --);
		}
	}
	
}
