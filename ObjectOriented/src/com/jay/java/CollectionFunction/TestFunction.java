package com.jay.java.CollectionFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * - 方法
 * binarySearch
 * -sort()
 * - shuffle()
 * - reverse()
 * - swap(List<?>list, int i, int j)
 * @author jay
 *
 */
public class TestFunction {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		TestReverse(list);
		
		
		list = new ArrayList<Integer>();
		for(int i = 0; i < 54; i++) {
			list.add(i);
		}
		
		//洗牌
		Collections.shuffle(list);
		//发牌
		List<Integer> p1 = new ArrayList<Integer>();
		List<Integer> p2 = new ArrayList<Integer>();
		List<Integer> p3 = new ArrayList<Integer>();
		List<Integer> last = new ArrayList<Integer>();
		
		//发牌
		for(int i = 0 ; i < 51;i+=3) {
			p1.add(list.get(i));
			p3.add(list.get(i + 1));
			p2.add(list.get(i + 2));
		}
		last.add(list.get(51));
		last.add(list.get(52));
		last.add(list.get(53));
		System.out.println("p1:"+p1);
		System.out.println("p2:"+p2);
		System.out.println("p3:"+p3);
		System.out.println("last:"+last);
	}
	//1. reverse
	public static <T>void TestReverse(List<T> list) {
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);

	}
	//2.模拟斗地主
}
