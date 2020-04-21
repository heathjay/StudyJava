package com.jay.java.Pattern.Singleton;
/**
 * 单例模式：
 * - 枚举方法实现
 * - 避免发射和反序列化漏洞
 * - 没有延时加载的效果
 * @author jay
 *
 */
public enum SingletonEnum {
	//这个枚举元素本身就是单例模式的对象，singleton对象
	INSTANCE;
	//添加自己需要的操作
	public void sinletonOperation() {
		
	}
}
