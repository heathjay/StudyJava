package com.jay.java.JVM;
/**
 * 测试简单的加密解密类加载器
 * @author jay
 *
 */
public class EncodeClassLoader {
	public static void main(String[] args) throws ClassNotFoundException {
		int a = 3;
/*		//位运算取反操作
		System.out.println(Integer.toBinaryString(a ^ 0xff));
*/	
		
		
		/*
		//Exception in thread "main" java.lang.ClassFormatError: Incompatible magic value 889275713 in class file HW
		FileSystemClassLoader loader = new FileSystemClassLoader("/Users/chengpengjiang/Documents/TestFileOper");
		Class<?> c = loader.loadClass("HW");
		System.out.println(c);
	*/
		DecryptClassLoader loader = new DecryptClassLoader("/Users/chengpengjiang/Documents/TestFileOper/dest");
		
		Class<?> c = loader.loadClass("HelloWorld");
		System.out.println(c);
	}
}
