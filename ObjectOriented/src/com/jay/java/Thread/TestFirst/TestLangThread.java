package com.jay.java.Thread.TestFirst;
/**

 * @author jay
 *
 */
public class TestLangThread extends Thread{
	public void run() {
		//线程体
		for(int i =0; i <100;i++) {
			System.out.println(Thread.currentThread().getName() + "兔子拍了" + i);
		}
	}
}
class Tortoise extends Thread{

	public void run() {
		//线程体
		for(int i =0; i <100;i++) {
			System.out.println(Thread.currentThread().getName() +"乌龟拍了" + i);
		}
	}
}