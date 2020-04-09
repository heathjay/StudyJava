package com.jay.java.DeepHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * javabean
 * - 用类存储
 * - key -对象-set/get
 * @author jay
 *
 */
public class TestOriented {
	public static void main(String[] args) {
		String[] arr = "this is a cat and that is a mice and where is the food?".split(" ");
		Map<String,Letter> map = new HashMap<String,Letter>();
		
		for(String key : arr) {
			if(!map.containsKey(key)) {
				map.put(key, new Letter(key));
			}
			Letter value = map.get(key);
			value.setCount(value.getCount()+1);		
/*//			
//			Letter value = map.get(key);
//			if(null == value) {
//				value = new Letter();
//				map.put(key, value);
//			}
//			value.setCount(value.getCount()+1);	
*/		}
		
		for(String key:map.keySet()) {
			Letter value = map.get(key);
			System.out.println(value.getCount());
		}
	}
}
