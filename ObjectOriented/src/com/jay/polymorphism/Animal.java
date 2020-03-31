package com.jay.polymorphism;

public class Animal {
	String str;
	public void shouting() {
		System.out.println("animal is shouting");
	}
	public Animal() {
		System.out.println("An animal is created");
	}
}

class Cat extends Animal{
	public void shouting() {
		System.out.println("cat is shouting");
	}
	public Cat() {
		System.out.println("A cat is created");
	}
	public void catchMouse() {
		System.out.println("a cat is catching a mouse");
	}
}

class Dog extends Animal{
	public void shouting() {
		System.out.println("dog is shouting");
	}
	
	public void watchDog() {
		System.out.println("to be a watchDoy");
	}
}

class  Pig extends Animal{
	public void shouting() {
		System.out.println("pig is shouting");
	}
}