package com.jay.java.Pattern.Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 测试反射和反序列化破解
 * @author jay
 *
 */
public class BreakClient {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		SingletonLazy a1 = SingletonLazy.getInstance();
		SingletonLazy a2 = SingletonLazy.getInstance();
		System.out.println(a1);
		System.out.println(a2);
/*		
		//反射：跳过单例
		Class<SingletonLazy> clz = (Class<SingletonLazy>) Class.forName("com.jay.java.Pattern.Singleton.SingletonLazy");
		Constructor<SingletonLazy> constructor = clz.getDeclaredConstructor(null);
		constructor.setAccessible(true);
		SingletonLazy a3 = constructor.newInstance();
		SingletonLazy a4 = constructor.newInstance();
		//可以通过构造器增加判断是否已经有单例生成来防止破解
		System.out.println(a3);
		System.out.println(a4);

*/		
		
		/**
		 * 序列化和反序列化
		 * - 需要实现一个接口serializable
		 * - 序列化写出
		 * - 反序列化生成新的对象
		 * - 一个类出现两个对象
		 * - 如何防止？
		 * 	- 通过定义一个readResolve方法
		 * 	- 反序列化时会自动调用这个方法.
		 */
		
		FileOutputStream fos = new FileOutputStream("/Users/chengpengjiang/Documents/coding/Java/java_study/StudyJava/ObjectOriented/src/com/jay/java/Pattern/Singleton/a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a1);
		fos.close();
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/chengpengjiang/Documents/coding/Java/java_study/StudyJava/ObjectOriented/src/com/jay/java/Pattern/Singleton/a.txt"));
		SingletonLazy a3 = (SingletonLazy)ois.readObject();
		
		System.out.println(a3);
		
		
		
	}
}
