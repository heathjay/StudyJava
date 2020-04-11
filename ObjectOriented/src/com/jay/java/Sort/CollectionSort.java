package com.jay.java.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collection 可以进行排序
 * -   public static <T> void sort(List<T> list, Comparator<? super T> c) {
        list.sort(c);
    }
    指定比较器
 * @author jay
 *
 */
public class CollectionSort {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("abcd");
		list.add("abc");
		Collections.sort(list,new jTestComparator());
		System.out.println(list);
		
		list = new ArrayList<String>();
		list.add("a");
		list.add("abcd");
		list.add("abc");
		Collections.sort(list);
		System.out.println(list);
		
	}
}
