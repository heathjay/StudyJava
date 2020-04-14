package com.jay.java.Thread.TestFirst;
/**
 *  * java.lang.Thread
 * public class Thread extends Object implements Runnable
 * main也是线程。
 * 1. 线程创建的第一种方式
 * - 继承extends , 重写run方法
 * - 使用线程：创建子类对象
 * - 调用start方法

 * @author jay
 *
 */
public class TestLangThreadApp {
	public static void main(String[] args) {
		TestLangThread rab = new TestLangThread();
		Tortoise tor = new Tortoise();
		//调用start方法, 内部由cpu进行调用
		rab.start();
		tor.start();
		for(int i =0; i <100;i++) {
			System.out.println(Thread.currentThread().getName() +"ss" + i);
		}
	}
}
