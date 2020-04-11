package com.jay.java.Sort;

import java.util.Comparator;
import java.util.List;

/**
 * 排序
 * @author jay
 *
 */

public class Utils {
	/**
	 * 泛型
	 */
	
	public static <T> void sort(List<T> list, Comparator<T> com) {
		Object[] arr = list.toArray()	;
		sort(arr,com);
		for(int i =0; i <arr.length;i++) {
			list.set(i, (T)(arr[i]));
		}
	}
	/**
	 * comparator接口进行排序
	 */
	public static <T>void sort(Object[] arr, Comparator<T> com) {
		boolean sorted = true;
		int len = arr.length;
		for(int i = 0; i < len - 1; i++) {
			sorted = true;//假定有序
			
			for(int j = 0; j < arr.length - i - 1; j++) {			
				if(com.compare((T)arr[j],(T)arr[j+1]) > 0) {
					Object temp = arr[j];
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
	/**
	 * 数组排序
	 * 泛型
	 */
	
	public static <T extends Comparable<T>> void sort(T[] arr) {
		boolean sorted = true;
		int len = arr.length;
		for(int i = 0; i < len - 1; i++) {
			sorted = true;//假定有序
			
			for(int j = 0; j < arr.length - i - 1; j++) {			
				if(arr[j].compareTo(arr[j+1]) > 0) {
					T temp = arr[j];
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
	
	/**
	 * 容器排序
	 */
	public static <T extends Comparable<T>> void sort(List<T> list) {
		//转成数组
		Object[] arr = list.toArray();
		sort((T[]) arr);
		for(int i = 0; i < arr.length; i++) {
			list.set(i, (T)(arr[i]));
		}
		
	}
}
