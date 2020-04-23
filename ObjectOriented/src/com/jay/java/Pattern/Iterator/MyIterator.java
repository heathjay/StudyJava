package com.jay.java.Pattern.Iterator;
/**
 * 迭代器接口
 * @author jay
 *
 */
public interface MyIterator {
	//将游标指向第一个
	void first();
	//游标指向下一个
	void next();
	//判断是否存在下一个元素
	boolean hasNext();
	
	boolean isFirst();
	boolean isLast();
	Object getCurrentObj();
}
