package com.jay.java.ReferenceRank;

import java.util.EnumMap;

/**
 * EnumMap
 * - 要求键值为枚举
 * @author jay
 *
 */
public class TestEnumMap {
	public static void main(String[] args) {
		EnumMap<Season,String> map = new EnumMap<Season,String>(Season.class);
		map.put(Season.SPRING, "1");
		map.put(Season.SUMMER, "1");
		map.put(Season.AUTUMN, "1");
		map.put(Season.WINTER, "1");
		System.out.println(map.size());
	}
}
enum Season{
	SPRING, SUMMER,AUTUMN, WINTER
}
