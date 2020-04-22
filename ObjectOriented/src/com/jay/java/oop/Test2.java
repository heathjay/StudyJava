package com.jay.java.oop;

public class Test2 {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("jay");
		s1.setAge(19);
		Computer c1 = new Computer();
		c1.brand = "dell";
		c1.cpuSpeed = 100;
		
		s1.computer = c1;
		System.out.println(s1.computer.brand);
	}
}
