package com.jay.java.Thread.TestStop;
/**
 * - 线程类中定义线程使用的表示
 * 		private boolean flag
 * - 线程体内使用标志
 * 			while(flag) {
 * - 对外提供方法改变标示
 * 				public void stop() {
		this.flag = false;
	}
	- 外部根据条件进行干涉
 *
 * Thread.stop() - 不推荐
 * @author jay
 *
 */
public class TestStop {

	public static void main(String[] args) {
		//他比runnable多了方法
		Study s = new Study();
		new Thread(s).start();
		//Thread sproxy = new Thread(s);
		//外部干涉
		for(int i = 0 ;i < 100;i++) {
			if(50 == i) {
				s.stop();
			}
			System.out.println("main");
		}
	}

}

class Study implements Runnable{
	//1
	private boolean flag = true;
	//2
	@Override
	public void run() {
		while(flag) {
			System.out.println("flag:" + flag);
		}
	}
	
	//3.
	public void stop() {
		this.flag = false;
	}
}