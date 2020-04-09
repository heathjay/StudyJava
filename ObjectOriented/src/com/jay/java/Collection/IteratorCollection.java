package com.jay.java.Collection;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 迭代器的使用
 * @author jay
 *
 */
public class IteratorCollection {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add(new String("bbb"));
		list.add("ccc");
		
		//Collection 里面有一个iterator
		for(Iterator it = list.iterator();it.hasNext();) {
			String str = (String) it.next()	;
			System.out.println(str);
		}
		
		Set set = new HashSet();
		set.add("jj");
		set.add("cc");
		set.add("aa");
		
		
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			String str = (String) iter.next();
			System.out.println(str);
		}
		
		
	}
}
