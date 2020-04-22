package com.jay.java.TestTreeSet;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

/**
 * 要求键值可以排序
 * @author jay
 *
 */
public class TestTreeMap {
	public static void main(String[] args) {
		Person p1 = new Person("jj", 100);
		Person p2 = new Person("jwj", 10);
		Person p3 = new Person("jaj", 120);
		Person p4 = new Person("jxj", 110);
		
		TreeMap<Person,String> map = new TreeMap<Person,String>(
				new Comparator<Person>() {

					@Override
					public int compare(Person o1, Person o2) {
						// TODO Auto-generated method stub
						return o1.getHandsome()	- o2.getHandsome();
					}

					
				}
				);
		
		map.put(p1, "1");
		map.put(p3, "1");
		map.put(p2, "1");
		map.put(p4, "1");
		
		
		Set<Person> persons = map.keySet();
		System.out.println(persons);
	}
}
