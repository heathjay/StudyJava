/**
 * 
 */
package com.jay.java.ReferenceRank;

import java.util.IdentityHashMap;

/**
 * 
 * IdentityHashMap 键值比较地址去重复
 * @author jay
 *
 */
public class TestIdentiyHashMap {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IdentityHashMap<String,String> map = new IdentityHashMap<String,String>();
		//常量池中存在即获取
		map.put("ss", "ss");
		map.put("ss", "s1s");
		System.out.println(map.size());
		map.put("sas", "s12s");
		map.put("sxxs", "sadss");
		//只比较地址
		map.put(new String("ss"), "sadss");
		map.put(new String("ss"), "sadss");
		
		
		System.out.println(map.size());

		System.gc();
		System.runFinalization();
		System.out.println(map.size());
		
	}

}
