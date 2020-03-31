package com.jay.oop;
/**
 * 
 * @author jay
 * @version 1.0
 *
 */
public class Student {
	//data
	private String name;
	private int id;
	private int age;
	private String gendar;
	private int weight;
	Computer computer;
	//method
	public void study() {
		System.out.println(this.name + " is studying");
	}
	
	public void sayHello(String name) {
		System.out.println(this.name + " say hello to " + name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("jay");
		s1.study();
		s1.sayHello("ha");
	}
}
