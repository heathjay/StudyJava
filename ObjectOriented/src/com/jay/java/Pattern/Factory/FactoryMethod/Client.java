package com.jay.java.Pattern.Factory.FactoryMethod;
/**
 * 如果想增加奔驰
 * - 加入奔驰实现类，实现Car的接口
 * - 加入奔驰工厂实现类，实现工厂的接口
 * - 不需要对其他代码进行改进
 * @author jay
 *
 */
public class Client {

	public static void main(String[] args) {
		Car c1 = new AudiFactory().createCar();
		c1.run();
		Car c2 = new BydFactory().createCar();
		c2.run();
	}

}
