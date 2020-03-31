package com.jay.java.TestInterface;
/**
 * 
 * @author jay
 * 建模共同点很少的时候
 *	interface extends A,B
 */
public interface Flyable {
	public static final int MAX_SPEED = 110000;
	public static final int MIN_HEIGHT = 1;
	public abstract void fly();
}

interface Attack{
	public abstract void attack();
}
interface AnF extends Flyable, Attack{
	public abstract void eat();
	//多继承
}
class Plane implements Flyable{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("plane is flying");
	}
	
}

class Man implements Flyable, Attack{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("man is flying");
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("Man is attacking");
	}
	
}
