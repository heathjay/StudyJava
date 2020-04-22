package com.jay.java.TestTreeSet;

import java.util.TreeSet;

/**
 * 
 * @author jay
 *
 */
public class WorkerApp {
	public static void main(String[] args) {
			Worker w1 = new Worker("xx", 12000);
			
			Worker w2 = new Worker("xsa", 402);
			Worker w3 = new Worker("xssa", 5402);
			
			TreeSet<Worker> employees = new TreeSet<Worker>();
			employees.add(w1);
			employees.add(w3);
			employees.add(w2);
			System.out.println(employees);
	}
}
