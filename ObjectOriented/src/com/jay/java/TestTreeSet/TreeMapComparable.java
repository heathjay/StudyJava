package com.jay.java.TestTreeSet;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * comparable
 * @author jay
 *
 */
public class TreeMapComparable {
	public static void main(String rags[]) {

		Worker w1 = new Worker("xsaa", 42);
		Worker w2 = new Worker("xsa", 402);
		Worker w3 = new Worker("xssa", 5402);
		
		TreeMap<Worker,String> employees = new TreeMap<Worker,String>();
		employees.put(w1,"1");
		employees.put(w2,"1");
		employees.put(w3,"1");

		System.out.println(employees);
	}
}
