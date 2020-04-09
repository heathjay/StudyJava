package com.jay.java.Collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * set
 *	底层是map实现的
 *	1. 测试HashSet怎么用
 *	2. 重写一个Set
 * @author jay
 *
 */
public class MyHashSet {
	private HashMap map;
	private static final Object PRESENT = new Object();
	 int size;
	public int size() {
		return map.size();
	}
	public MyHashSet() {
		this.map = new HashMap();
	}
	
	public void add(Object e) {
		map.put(e, PRESENT);//Set里面的不可重复依靠map的键值不可重复

	}
	
	public void remove(Object e) {
		map.remove(e);
	}
	public static void main(String[] args) {
		Set s = new HashSet();
		s.add("jj");
		s.add("aaa");
		//equals的值直接覆盖
		s.add(new String("jj"));
		System.out.println(s.size());
		System.out.println(s.contains("jj"));
	
		MyHashSet ss = new MyHashSet();
		ss.add(new String("bnbb"));
		System.out.println(ss.size());
	}
}
