package com.jay.java.Pattern.Factory;
/**
 * 简单工厂情况下
 * - static create方法
 * @author jay
 *
 */
public class ClientWithSimpleFactory {
	public static void main(String[] args) {
		Car c1 = CarFactory.createCar("Audi");
		Car c2 = CarFactory.createCar("Byd");
		c1.run();
		c2.run();
	}
}
