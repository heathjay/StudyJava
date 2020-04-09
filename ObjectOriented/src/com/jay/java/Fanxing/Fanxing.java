package com.jay.java.Fanxing;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 * - 标签
 * - 泛化类型
 * - 方便
 * - 安全:类型检查
 * - 取出来的时候不用任何类型转换
 * - 多种数据类型执行相同功能的代码
 * - 一个模版
 * - 使用时进行指定
 * - 主要用到集合里面
 * 
 * 任意化：
 * 	- 学生类：
 * 		- 成绩： 整数，小数，字符串
 * 	- Object类
 * @author jay
 *- 泛型类 - 类<T ...>
 *	- 类名的后面加上，可以多个，  
 *	- 尖括号里面写单个字母。简明知道，随意 T type K key E element V value,
 *	- 泛型不能使用在静态属性
 *	- 成员变量和引用类型
 *- 泛型接口 接口<T,>
 *	- 前局常量- 不能使用在这里public static final 是会被自动添加的
 *	- 公共的抽象方法
 *- 泛型方法的定义
 *	-<T> 返回值类型 | void 
 *	- 可以在非泛型的类中
 *	- 在返回类型前面加入尖括号
 *- 父类是泛型类
 */
interface Computer<T>{
	
//	private static final int MAX_VALUE = 99;
	void compute(T t);
	T computeA(T t);
}
public class Fanxing {
	
	public static <T>void test(T t) {
		System.out.println(t);
	}
	
	public static <T extends Closeable> void test01(T... a) {//可变参数，和数组使用方式一样
		for(T tmp:a) {
			if(null!= tmp) {
				try {
					tmp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static <T extends List>void test(T t) {
		System.out.println(t);
		t.add("aa");
	}
	public static void main(String[] args) {
		List<String> list= new ArrayList<String>();
		list.add("good");
		System.out.println(list.get(0));
		
		test("good");
		List list2 = new ArrayList();
		list2.add("ddd");
		//手动类型转换
		//类型检查
		String str = (String) list2.get(0);
		System.out.println(str);
		
		//javabean存储
		Stu st = new Stu(99);
		
		Object j = st.getJavase();
		if (j instanceof Integer) {
			Integer in = (Integer)j;
			System.out.println(in);
		}
		
		//2. 自定义泛型类的使用，在声明的同时，指定具体的类，这个类不能是基本类型，只能是引用类型
		Stus<Integer> sts = new Stus<Integer>();
		sts.setJavase(11);
		//类型检查
		//自动类型转换，免去类型检查
		Integer score = sts.getJavase();
	}
}
//泛型类
//
class Stu{
	private Object javase;

	public Stu() {
		super();
	}

	public Stu(Object javase) {
		super();
		this.javase = javase;
	}

	/**
	 * @return the javase
	 */
	public Object getJavase() {
		return javase;
	}

	/**
	 * @param javase the javase to set
	 */
	public void setJavase(Object javase) {
		this.javase = javase;
	}
}
class Stus<T>{
	private T javase;
	//private static T dd;

	public Stus() {
		super();
	}

	public Stus(T javase) {
		super();
		this.javase = javase;
	}

	/**
	 * @return the javase
	 */
	public T getJavase() {
		return javase;
	}

	/**
	 * @param javase the javase to set
	 */
	public void setJavase(T javase) {
		this.javase = javase;
	}
}
