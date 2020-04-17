package com.jay.jave.ref;
/**
 * 测试java.lang.Class对象的测试方法
 * - 一个类只对应一个对象，
 * - 常用：
 * 	- 动态加载类，动态获取类信息
 * 	- 动态构造对象
 * 	- 动态调用类和对象的任意方法
 * 	- 动态调用和处理属性
 * 	- 获取泛型信息
 * 	- 处理注解
 * - class 获取
 * 	- Class.forName(path)
 * 	- 对象.getClass
 * 	- 类.Class
 * 
 * - 基本数据类型 primitive type
 * 	- int.getClass
 * 	- int[].getClass - 跟他的维数有关系
 * 	- double[] 和int[] 类也不同
 * 
 */

import com.jay.java.Network.HttpsProject.MultiTaskUpdated.Servlet;
@SuppressWarnings("all")
public class Test {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		/*Class<?> clz = Class.forName("com.jay.java.Network.HttpsProject.MultiTaskUpdated.LoginServlet");
		Servlet src = (Servlet) clz.newInstance();*/
		
		
		String str ="com.jay.jave.ref.User";
		Class<?> clz = Class.forName(str);
		Class<?> clz1 = Class.forName(str);
		
		System.out.println(clz.hashCode());
		System.out.println(clz1.hashCode());
		//类.class
		Class strClz = String.class;
		//对象.getClass
		Class strClz2 = str.getClass();
		System.out.println(strClz);
		System.out.println(strClz2);
		
		//数组和几维有关系
		int[] arr01 = new int[10];
		int[] arr02 = new int[20];
		
		System.out.println(arr01.getClass().hashCode());
		System.out.println(arr02.getClass().hashCode());
	}
	

}
