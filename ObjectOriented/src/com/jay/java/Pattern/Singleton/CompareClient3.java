package com.jay.java.Pattern.Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程环境下物种创建单例模式的效率
 * @author jay
 *
 */
public class CompareClient3 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, InterruptedException {
		long start = System.currentTimeMillis();
		int threadNum = 10;
		
		final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
		for(int i = 0; i < threadNum ;i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					for(int i = 0; i < 100000;i++) {
						Object o = SingletonDemo.getInstance();
					}
					countDownLatch.countDown();
				}
				
			}).start();
		}
		countDownLatch.await();//main线程阻塞，直到计数器变为0，才会继续往下执行
		long end = System.currentTimeMillis();
		System.out.println("总时间:" + (end - start));
		
		
		
	}
}
