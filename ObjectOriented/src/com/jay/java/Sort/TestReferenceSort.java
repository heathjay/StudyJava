package com.jay.java.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 引用类型的排序
 * - 我们的业务的排序规则
 * - java.lang.comparable接口
 * - 重写public int compareTo(Object obj);
 * - 返回0, 表示this==object
 * - 返回正数 this > obj;
 * - 返回负数 this < obj;
 * 
 * - 内置类
 * 	- 正数Integer
 *  - String
 * @author jay
 *
 */
public class TestReferenceSort {
	public static void main(String[] args) {
		Integer a;
		String b;
		java.util.Date d;
		Object obj;
		Date[] arr= new Date[3];
		arr[0] = new Date();
		arr[1] = new Date(System.currentTimeMillis() - 1000*60*60);
		arr[2]= new Date(System.currentTimeMillis() + 1000*60*60);
		Utils.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
//		List<String> list = new ArrayList<String>();
//		list.add("a");
//		list.add("abcd");
//		list.add("abc");
//		Utils.sort(list);
//		System.out.println(list);
//		String[] arr2 = new String[] {"a", "abcd", "abc","def"};
//		Utils.sort(arr2, new jTestComparator());
//		System.out.println(Arrays.toString(arr2));
		
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("abcd");
		list.add("abc");
		Utils.sort(list, new jTestComparator());
		System.out.println(list);
		
	}
	//内部类比较可以写一个工具类进行使用
	public static void sort2(String[] arr) {
		boolean sorted = true;
		int len = arr.length;
		for(int i = 0; i < len - 1; i++) {
			sorted = true;//假定有序
			
			for(int j = 0; j < arr.length - i - 1; j++) {			
				if(arr[j].compareTo(arr[j+1]) > 0) {
					String temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted= false;
				}
			}
			if(sorted) {
				break;
			}
		}
	}
	

	public static void sort3(Date[] arr) {
		boolean sorted = true;
		int len = arr.length;
		for(int i = 0; i < len - 1; i++) {
			sorted = true;//假定有序
			
			for(int j = 0; j < arr.length - i - 1; j++) {			
				if(arr[j].compareTo(arr[j+1]) > 0) {
					Date temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted= false;
				}
			}
			if(sorted) {
				break;
			}
		}
	}
}
