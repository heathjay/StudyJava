package com.jay.java.JVM;
/**
 * 测试自定义流
 * - 同一个类被不同加载器加载，JVM认为也是不相同的类
 * @author jay
 *
 */
public class TestFileSystemClassLoader {
	public static void main(String[] args) throws ClassNotFoundException {
		FileSystemClassLoader loader = new FileSystemClassLoader("/Users/chengpengjiang/Documents/TestFileOper");
		FileSystemClassLoader loader2 = new FileSystemClassLoader("/Users/chengpengjiang/Documents/TestFileOper");
		
		Class<?> c = loader.loadClass("HelloWorld");
		System.out.println(c.hashCode());
		System.out.println(c.getClassLoader());	//自定义加载器
		Class<?> c1 = loader.loadClass("java.lang.String");	//引导类加载器
		System.out.println(c1.hashCode());
		System.out.println(c1.getClassLoader());
		Class<?> c2 = loader.loadClass("com.jay.java.JVM.Test01");	//引导类加载器
		System.out.println(c2.hashCode());
		System.out.println(c2.getClassLoader());//系统加载器AppClassLoader
		
	}
}
