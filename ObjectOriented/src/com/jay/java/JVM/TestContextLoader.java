package com.jay.java.JVM;
/**
 * 检测上下文加载类
 * @author jay
 *
 */
public class TestContextLoader {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader = TestContextLoader.class.getClassLoader();
		System.out.println(loader);
		//$AppClassLoader
		ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
		System.out.println(loader2);
		//新的类加载器
		Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("/Users/chengpengjiang/Documents/TestFileOper"));
		System.out.println(Thread.currentThread().getContextClassLoader());
		
		Class<Encryption> c = (Class<Encryption>)Thread.currentThread().getContextClassLoader().loadClass("com.jay.java.JVM.Encryption");
		System.out.println(c);
		System.out.println(c.getClassLoader());
	}
}
