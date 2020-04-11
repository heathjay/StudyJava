package com.jay.java.ReferenceRank;

import java.util.WeakHashMap;

/**
 * WeakHashMap 键值为弱引用，gc运行立即回收	
 * @author jay
 *
 */
public class TestWeakHashMap {
	public static void main(String[] args) {
		WeakHashMap<String, String> map = new WeakHashMap<String,String>();
		//测试数据
		map.put("ss", "ss");
		map.put("s21s", "s1s");
		map.put("sas", "s12s");
		map.put("sxxs", "sadss");
		map.put(new String("sxsxs"), "sadss");
		map.put(new String("sxsxaws"), "sadss");
		
		
		System.out.println(map.size());

		System.gc();
		System.runFinalization();
		System.out.println(map.size());
	}
}
