package com.jay.java.TestAutoBoxing;
/**
 * 
 * @author jay
 * 自动装箱
 *
 */
public class TestAutoBoxing {
	public static void main(String[] args) {
		//通过编译器的改变帮助我们改进代码
		//Integer a = new Integer(2);
		Integer a = 1000; //jdk5.0之后，
		//编译器改进
		//new Integer(2).intValue();
		int c = new Integer(2);
		//a.intValue()
		//但是如果a是null， 调用null.intValue（）会报错
		int d = a;
		//作比较时我们把其中的对象当作基本数据类型来对待
		Integer d3 = 123;
		Integer d4 = 123;
		System.out.println(d3 == d4);
		System.out.println(d3.equals(d4));
		
		Integer d1 = 1232241;
		Integer d2 = 1232241;
		System.out.println(d3 == d4);
		System.out.println(d3.equals(d4));
	}
}
