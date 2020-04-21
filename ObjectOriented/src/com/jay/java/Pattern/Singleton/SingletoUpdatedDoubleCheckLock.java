package com.jay.java.Pattern.Singleton;
/**
 * 双层检测锁实现
 * - 这个模式将同步内容下方到if内部，提高执行的效率，不必每次获取对象时都要进行同步，只有第一次才同步，创建了以后就没有必要了
 * - 问题：
 * 		由于编译器优化原因和jvm底层内部模型原因，偶尔出现问题，不建议使用
 * @author jay
 *
 */
public class SingletoUpdatedDoubleCheckLock {
	private static SingletoUpdatedDoubleCheckLock instance;
	private SingletoUpdatedDoubleCheckLock() {
		
	}
	
	public static SingletoUpdatedDoubleCheckLock getInstance() {
		if(instance == null) {
			SingletoUpdatedDoubleCheckLock temp;
			synchronized(SingletoUpdatedDoubleCheckLock.class) {
				temp = instance;
				if(temp == null) {
					synchronized(SingletoUpdatedDoubleCheckLock.class) {
						if(temp == null) {
							temp = new SingletoUpdatedDoubleCheckLock();
						}
					}
					instance = temp;
				}
			}
		}
		return instance;
	}
}
