package com.jay.java.Collection;

import java.util.LinkedList;

/**
 * 快速查询的Map
 * 使用hash
 * @author jay
 * map的底层实现是通过数组+链表
 */
public class TestFastMap {
	//map的底层结构是数组加上链表
	LinkedList[] arr = new LinkedList[990];
	int size;
	
	public void put(Object key, Object value) {
		SxtEntry e = new SxtEntry(value,key);
		int a = key.hashCode() % arr.length;
		//如果不冲突
		if(arr[a] == null) {
			LinkedList list = new LinkedList();
			arr[a] = list;
			list.add(e);
			
		}else {
			LinkedList list = arr[a];
			for(int i = 0; i < list.size(); i++) {
				SxtEntry e1 = (SxtEntry) list.get(i);
				if(e1.key.equals(key)) {
					e1.value = value;
					return;
				}
			}
		}
			arr[a].add(e);
	}
	
	public Object get(Object key) {
		int a = key.hashCode() % arr.length;
		if(arr[a] != null) {
			LinkedList list = arr[a];
			for(int i = 0; i < list.size(); i++) {
				SxtEntry e = (SxtEntry) list.get(i);
				if(e.key.equals(key)) {
					return e.value;
				}
			}		
		}
		return null;
	}
	public static void main(String[] args) {
		
	}
}
