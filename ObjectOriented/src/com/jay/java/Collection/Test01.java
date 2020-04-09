package com.jay.java.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * collection
 * - set
 * - list
 * 	- ArrayList
 * 	- 
 * - map
 * @author jay
 *
 */

public class Test01 {


	public static void main(String[] args) {
		//List用多态，编译器编译的时候用的是list
		//一边情况下用arraylist够，底层是数组，所以查询快，修改，删除，插入慢
		//LinkedList底层实现是链表，所以查询慢，修改插入删除快
		//Vector：线程安全的，效率低
		List list = new ArrayList();
		list.add("aa");
		list.add(new Date());
		list.add(new Object());
		
		//跟数组不一样，数组是知道总的数组
		//但是list的size（）和ArrayList数组长度不一样
		System.out.println(list.size());
		
		System.out.println(list.isEmpty());
		
		list.remove("aa");
		System.out.println(list.size());
		
		List list2 = new ArrayList();
		
		list2.add("xxx");
		list2.add("xxxa");
		list.addAll(list2);
		System.out.println(list.size());
		list.add(list2);
		System.out.println(list.size());
		
		String str = (String) list.get(2);
		System.out.println(str);
		
		//equals-hashcode 去判断是否相等,
		//
	}

}
