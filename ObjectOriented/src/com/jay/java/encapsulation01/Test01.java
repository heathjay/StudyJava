package com.jay.java.encapsulation01;
/**
 * 
 * @author jay
 * private
 * protected - 包内
 *
 */
public class Test01 {
	private String str;
//	private void print() {
//		System.out.println("Test01.print()");
//	}
	protected void print() {
		System.out.println("Test01.print()");
	}
	
}

class Test3 extends Test01{
	public void pp() {
		super.print();
	}
}
