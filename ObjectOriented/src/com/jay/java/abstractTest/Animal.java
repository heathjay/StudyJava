package com.jay.java.abstractTest;
/**
 * 
 * @author jay
 * abstract 使用
 *	避免子类的随意性，严格限制子类的随意性，提供通用模版，可以进行扩充，加上注解可以提高正确了
 *	抽象类必须包含抽象方法，没有方法体，
 *	但可以包含属性方法，
 */
public abstract class Animal {
	String str;
	public abstract void run() ;
	public void breath() {
		System.out.println("animal breathes");
		run(); 	//多态
	}
	
}

class Cat extends Animal{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("cat is running ");
	}

}