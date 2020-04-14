package com.jay.java.Thread.TestFirst;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 3. java.util.concurrent 
 * 	1. 实现Callable接口，重写call方法
 * 	//1.使用调度器,创建几个线程
		ExecutorService ser = Executors.newFixedThreadPool(2);
		//2. 获取那个值， Future 接口用来将来获取
		Race toitoise = new Race();
		Future<Integer> result = ser.submit(toitoise);
		
		//3.Future get方法等待获取结构
		int num = result.get();
		
		//4.停止服务
		ser.shutdown();
		
 * - 可以用来处理异常
 * @author jay
 *
 */
public class Call {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//1.使用调度器,创建几个线程
		ExecutorService ser = Executors.newFixedThreadPool(2);
		//2. 获取那个值， Future 接口用来将来获取
		Race toitoise = new Race("xxx");
		Race rr = new Race("xxx");
		Future<Integer> result = ser.submit(toitoise);
		Future<Integer> result2 = ser.submit(rr);
		Thread.sleep(2000);
		toitoise.setFlag(false);// 停止线程体循环
		rr.setFlag(false);
		//3.Future get方法等待获取结构
		int num = result.get();
		int num2 = result2.get();
		
		//4.停止服务
		ser.shutdown();
	}
}
class Race implements Callable<Integer>{
	
	private String name; 
	private int time;
	private boolean flag = true;
	private int step = 0;
	
	public Race() {
		
	}

	@Override
	public Integer call() throws Exception {
		while(flag) {
			Thread.sleep(time);//延迟
			step++;
		}
		return step;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public Race(String name) {
		super();
		this.name = name;
	}
	
	
}
