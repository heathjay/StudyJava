package com.jay.java.xml;
/**
 * 继承方法父类是不是调用一次
 * @author jay
 *
 */
public class Stu {
	public static void main(String[] args) {
		a b = new a();
		b.test();
	}
	public void test() {
		System.out.println("stu test");
	}
}
 class a extends Stu{
	@Override
	public void test() {
		System.out.println("a test");
	}
	
}
