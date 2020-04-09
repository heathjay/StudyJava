package com.jay.java.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2. 存储雇员信息，不用javabean
 * 	一行记录用一个map来封装
 * @author jay
 *
 */
public class TestCollectionEmployees {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("id", 0101);
		map.put("Name", "Gao");
		map.put("salary", 111);
		map.put("hireDate", "2007-11-1");
		
		Map map1 = new HashMap();
		map1.put("id", 11);
		map1.put("Name", "ccc");
		map1.put("salary", 111);
		map1.put("hireDate", "2007-11-1");
		
		
		Map map2 = new HashMap();
		map2.put("id", 12);
		map2.put("Name", "ddw");
		map2.put("salary", 111);
		map2.put("hireDate", "2007-11-1");
		
		//然后把存储条目放进collection 里面
		List<Map> list = new ArrayList<Map>();
		
		list.add(map);
		list.add(map1);
		list.add(map2);
	
		printEmployees(list);
	}
	public static void printEmployees(List<Map> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).get("Name"));
		}
	}
}
