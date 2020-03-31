package com.jay.polymorphism;
/**
 * 
 * @author jay
 * polymorphism
 *
 */
public class TestPolymorphism {
	//没有多态的时候，重载多次
//	public static void testAnimalVoice(Cat c) {
//		c.shouting();
//	}
//	public static void testAnimalVoice(Dog c) {
//		c.shouting();
//	}
//	public static void testAnimalVoice(Pig c) {
//		c.shouting();
//	}
	public static void testAnimalVoice(Animal c) {
		c.shouting();
		if(c instanceof Cat) {
			((Cat)c).catchMouse();
		}
	}
	public static void main(String[] args) {
		Cat c = new Cat();
		// Animal a = c;
		//父类的引用指向子类的对象
		Animal a = new Cat();
		Animal b = new Dog();
		Animal p = new Pig();
		//编译器只认声明的是什么，父类调用不了他没有的方法
		testAnimalVoice(a);
		testAnimalVoice(b);
		testAnimalVoice(c);
		
	}
}
