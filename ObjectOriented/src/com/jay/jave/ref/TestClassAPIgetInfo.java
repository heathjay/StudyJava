package com.jay.jave.ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 1. 应用反射API获得类的方法，属性构造器等信息
 * - 类名
 * 		getName() 包名+类名
 * 		getSimpleField 类名
 * - 属性
 * 		//getDeclaredFields所有属性
 * 		//getFields- 只返回public的属性
 * - 方法
 * 		//获取方法
		//getMethods- 只返回public的方法

 *- 构造器
 *
 *2. 动态调用方法、属性、构造器
 *- 动态操作构造器。
 *	- newInstance()-调用无参构造
 *		- javabean 必须要有无参构造
 *	- 指定构造器
 *		Constructor<User> c =  (Constructor<User>) clz.getDeclaredConstructor
 *		- c.newInstance("shuhs",11)
 *-动态调用方法	
 *	- Method method = clz.getDeclaredMethod
 *	- method.invoke(u2, "xxx");
 *- 动态调用属性
 *	- 
 * @author jay
 *
 */
public class TestClassAPIgetInfo {
	public static void main(String[] args) {
		String path= "com.jay.jave.ref.User";
		try {
			Class<?> clz = Class.forName(path);
			//动态构造对象。
			User u1 = (User) clz.newInstance();
			System.out.println(u1);
			
			Constructor<User> c =  (Constructor<User>) clz.getDeclaredConstructor(String.class, int.class);
			User u2 = c.newInstance("huhsu",11);
			System.out.println(u2);
			
			//调用方法setUname("xxx")
			Method method = clz.getDeclaredMethod("setuName", String.class);
			method.invoke(u2, "xxx");
			System.out.println(u2.getuName());
			
			//操作属性
				//不能操作私有属性
			Field f = clz.getDeclaredField("uName");
				//不做安全检查直接访问，method也可以，
			f.setAccessible(true);
			f.set(u2, "ianshc");
			System.out.println(u2.getuName());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Test1
	 */
	public static void Test1() {
		String path= "com.jay.jave.ref.User";
		try {
			Class<?> clz = Class.forName(path);
			
			//获取类名
				//包名—+类名
			System.out.println(clz.getName());
				//类名
			System.out.println(clz.getSimpleName());
			
			//获取属性
				//getFields- 只返回public的属性
			Field[] publicfields = clz.getFields();
			System.out.println(publicfields.length);
				//getDeclaredField所有属性
			Field[] allFields = clz.getDeclaredFields();
			for(Field f : allFields) {		
				System.out.println("属性="+f);
			}
			
			//获取方法
				//getMethods- 只返回public的方法
			Method[] publicMethod = clz.getDeclaredMethods();
			System.out.println(publicMethod.length);
				//getDeclaredMethod
			Method[] allMethods = clz.getDeclaredMethods();
			for(Method f : allMethods) {		
				System.out.println("方法"+f);
			}
			
				//getDeclaredMethod
					//参数是方法名字和参数类型
			try {
				Method m01 = clz.getDeclaredMethod("getUname", null);
				Method m02 = clz.getDeclaredMethod("setUname", String.class);
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//构造器信息
				//所有构造器 getDeclaredConstructors
			Constructor[] constructors = clz.getDeclaredConstructors();
			for(Constructor c : constructors) {
				System.out.println(c);
			}
			
			Constructor c1 = clz.getConstructor(String.class,int.class);
			Constructor c2 = clz.getConstructor();
			System.out.println();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
