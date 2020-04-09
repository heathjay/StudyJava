package com.jay.java.Collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 实验map
 * 通过多态，Map map指向子类的new
 * 
 * @author jay
 * 自定义实现Map
 * 1. 定义一个entry
 */

class SxtEntry{
	Object value;
	Object key;
	public SxtEntry(Object value, Object key) {
		super();
		this.value = value;
		this.key = key;
	}
	
}
public class MyMap {
	SxtEntry[] arr = new SxtEntry[990];
	int size;
	
	public void put(Object key, Object value) {
		
		SxtEntry e = new SxtEntry(value,key);
		for(int i = 0; i < size; i++) {
			if(arr[i].key.equals(key)) {
				arr[i].value = value;
				return;
			}
		}
		arr[size++]= e;
	}
	
	public Object get(Object key) {
		for(int i = 0; i < size; i++) {
			if(arr[i].key.equals(key)) {
				return arr[i].value;
			}
			
		}
		return null;
	}
	
	public boolean containsKey(Object key) {
		for(int i = 0; i < size; i++) {
			if(arr[i].key.equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsValue(Object value) {
		for(int i = 0; i < size; i++) {
			if(arr[i].value.equals(value)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("xxx", new Wife("ddd"));
		map.put("adsx", new Wife("jsijsi"));
		//通过一个对象找另一个对象，需要进行转型，如果依靠范性就不需要进行转型了
		Wife w = (Wife) map.get("xxx");
		System.out.println(w.name);
		
		
		MyMap m = new MyMap();
		
		m.put("gg", new Wife("ss"));
		m.put("xx", new Wife("sjssj"));
		m.put("gg",	 new Wife("saa"));
		
		Wife a = (Wife)m.get("gg");
		System.out.println(a.name);
		
	}
}
class Wife{
	String name;
	public Wife(String name) {
		this.name = name;
	}
	
}