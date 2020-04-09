package com.jay.java.DeepHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * - 一对多
 * - 举例子，包裹和地方
 * 		- 北京包裹一个，准备地方
 * 		- 上海包裹，准备地方
 * 		- 。。。
 * - 分拣存储：
 * 存储单词次数
 * this is a cat and that is a mice and where is the food?
 * 
 * 思路
 * - 分割字符串
 * - 分拣存储
 * - 按要求查看次数
 * 		- set和map配合使用，set不重复 map.keySet()
 * - javaBean 包含setter和getter访问的类
 * @author jay
 *
 */
public class TestHashMapNToN {
	public static void main(String[] args) {
		//1.分割字符串
		String[] arr = "this is a cat and that is a mice and where is the food?".split(" ");
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(String key: arr) {
			System.out.println(key);
			//2.分拣存储
			if(!map.containsKey(key)) {
			//if(null = map.get(key))//也可以
				//未存在
				map.put(key, 1);
			}else {
				//存在
				map.put(key, map.get(key) + 1);
			}
		}
		
		//3.查看
		Set<String>	keySet = map.keySet();		
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Integer value = map.get(key);
		}
		
	}
}
