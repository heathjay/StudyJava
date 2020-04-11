package com.jay.java.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author jay
 *
 */
public class NewsItemApp {
	public static void main(String[] args) {
		List<RefSortNewsItem> list = new ArrayList<RefSortNewsItem>();
		list.add(new RefSortNewsItem("good", 100, new Date()));
		list.add(new RefSortNewsItem("bad", 10, new Date(System.currentTimeMillis() + 10000*60*60)));
		list.add(new RefSortNewsItem("baqd", 10, new Date(System.currentTimeMillis() + 10000*60*60)));
		System.out.println(list);
		
		//排序
		Collections.sort(list);
		System.out.println(list);
		
	}
	
	
}
