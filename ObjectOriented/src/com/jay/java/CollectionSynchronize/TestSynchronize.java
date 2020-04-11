package com.jay.java.CollectionSynchronize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 使用Collections.synchronizedLIist()
 * 使用Collections.synchronizedSet()
 * 使用Collections.synchronizedLMap()
 * 
 * - 只读设置
 * 	 - emptyXxx() -空的不可变的集合处理空指针异常，不用处理nullpointerexception
 * 		Xxx = List, Map, Set
 * 	- singletonXxx(T o)- 一个元素不可变
 * 	- unmodifiableXxx 不可变容器
 * @author jay
 *
 */
public class TestSynchronize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		
		//List同步
		List<String> list2 = Collections.synchronizedList(list);
		System.out.println("线程安全");
		
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("aa", "s");
		map.put("aaa", "s");
		//只读控制
		Map<String,String> map2 = Collections.unmodifiableMap(map);
		//map2.put
		System.out.println(map2);
		
		//只有一个元素的容易
		List<String> list3 = Collections.singletonList(new String());
		list.add("sss");
		
		//没有元素
		//写一个方法
	}
	
	
	public static Set<String> oper(Set<String> set){
		//没有元素
				//写一个方法
		//返回不用处理空指针的问题
		if(null == set) {
			return Collections.EMPTY_SET;
		}
		return set;
	}

}
