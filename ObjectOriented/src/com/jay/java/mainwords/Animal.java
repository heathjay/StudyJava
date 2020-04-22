package com.jay.java.mainwords;
/**
 * 继承
 * @author jay
 *
 */
public class Animal {
	private String eyes;
	public void run() {
		System.out.println("animal runs");
	}
	
	public void eat() {
		System.out.println("animal eats");
	}
	public Animal(){
		System.out.println("create a animal");
	}
}


class Mammal extends Animal{
	public void taisheng() {
		System.out.println("我是胎生");
	}
	//overide
	public void run() {
		System.out.println("mammal is running");
	}
	public Mammal() {
		super();
		System.out.println("新建一个哺乳动物");
	}
}

class Bird extends Animal{
	public void ruansheng() {
		System.out.println("我是卵生");
	}
}