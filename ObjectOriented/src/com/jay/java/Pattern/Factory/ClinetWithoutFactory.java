package com.jay.java.Pattern.Factory;
/**
 * 没有工厂模式
 * @author jay
 *
 */
public class ClinetWithoutFactory {
	public static void main(String[] args) {
		
		//需要直到如何new，以及参数
		Car c1 = new Audi();
		Car c2 = new Byd();
		c1.run();
		c2.run();
	}
}
