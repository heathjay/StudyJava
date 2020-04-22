package com.jay.java.Pattern.Prototype;
/**
 * 模拟new一个对象比较消耗时间
 * @author jay
 *
 */
public class ComparedClient {

	public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
		testNew(100);
		testClone(100);
	}
	public static void testNew(int size) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		for(int i = 0 ;i < size;i++) {
			Laptop t = new Laptop();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
	public static void testClone(int size) throws InterruptedException, CloneNotSupportedException {
		long startTime = System.currentTimeMillis();
		Laptop t = new Laptop();
		for(int i = 0 ;i < size;i++) {
			Laptop temp = (Laptop)t.clone();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
}
class Laptop implements Cloneable{
	public Laptop() throws InterruptedException {
		Thread.sleep(10);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {	
		return super.clone();
	}
	
	
}