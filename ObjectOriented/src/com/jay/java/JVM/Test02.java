package com.jay.java.JVM;
/**
 * java.lang.ClassLoader
 * @author jay
 *
 */
public class Test02 {
	public static void main(String[] args) {
		//应用程序加载器
		System.out.println(ClassLoader.getSystemClassLoader());//$JAVA_HOME/classPath
		//扩展类加载器
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		//引导类加载器(C来写的)
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
	
		System.out.println(System.getProperty("java.class.path"));
	}
}
