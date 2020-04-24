package com.jay.java.Pattern.Memento;

public class Client {
	public static void main(String[] args) {
		CareTaker taker = new CareTaker();
		
		Emp emp = new Emp("jj",19,900);
		System.out.println("1:"+emp.getEname()+emp.getAge());
		
		taker.setMmt(emp.memento());
		
		emp.setAge(38);
		emp.setEname("jay");
		
		System.out.println("2:"+emp.getEname()+emp.getAge());
		
		emp.recovery(taker.getMmt());
		
		System.out.println("3:"+emp.getEname()+emp.getAge());
	}
}
