package com.jay.java.Pattern.Singleton;
/**
 * 单例模式：
 * - 静态内部类形式实现：
 * 	- 外部类没有static属性，则不会像饿汉那样立即加载
 * 	- 只有真正调用getInstance才会加载静态内部类，加载类是线程安全的，instance是static final类型，保证了内存中只有一个这样的实例存在，而且只能被赋值一次，从而保证线程安全
 * 	- 兼备了并发高效调用和延迟加载的优势
 * 
 * - 懒加载
 * - 线程安全
 * - 调用效率高
 * @author jay
 *
 */
public class SingletonUpdatedStaticInstance {
	//类加载天然线程安全，延迟加载，
	static {
		System.out.println("outer");
	}
	private static class SingletonClassInstance{
		static {
			System.out.println("inner");
		}
		private static final SingletonUpdatedStaticInstance instance = new SingletonUpdatedStaticInstance();
	}
	//调用效率高
	public static SingletonUpdatedStaticInstance getInstance() {
		return SingletonClassInstance.instance;
	}
	
	private SingletonUpdatedStaticInstance() {
		
	}
	public static void main(String[] args) {
		SingletonUpdatedStaticInstance a = new SingletonUpdatedStaticInstance();
		a.getInstance();
	}
}
