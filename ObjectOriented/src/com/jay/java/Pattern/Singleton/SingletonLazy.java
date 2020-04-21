package com.jay.java.Pattern.Singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 单例模式：懒汉式
 * 
 * - lazy load，延迟加载，真正用的时候进行加载
 * - 资源利用率高，但是每次调用getInstance需要同步，并发效率低
 * - 不初始化想要用的对象，
 * @author jay
 *
 */
public class SingletonLazy implements Serializable{
	private static SingletonLazy instance;
	private SingletonLazy() {
		if(null != instance) {
			//可以通过构造器增加判断是否已经有单例生成来防止破解
			throw new RuntimeException();
		}
	}
	
	public static synchronized SingletonLazy getInstance() {
		if(instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}
	/**
	 * 反序列直接返回当前instance
	 * @return
	 * @throws ObjectStreamException
	 */
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
}
