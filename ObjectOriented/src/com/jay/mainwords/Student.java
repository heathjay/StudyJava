package com.jay.mainwords;
/**
 * 
 * @author jay
 * 关键字
 * static
 *
 */
public class Student {
	private String name;
	int id;
	
	static int ss;
	
	public static void printSS() {
		System.out.println(ss);
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Student(String name, int id) {
		this();//it should be first statement in the methods;
		this.name = name;
		this.id = id;
	}
	
	public Student() {
		System.out.println("this is an object");
	}
}
