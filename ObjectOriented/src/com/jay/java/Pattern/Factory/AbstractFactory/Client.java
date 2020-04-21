package com.jay.java.Pattern.Factory.AbstractFactory;
/**
 * abstract factory
 * - 概率低，
 * 要点
 * 	- 简单工厂模式：虽然不符合设计原则，但实际使用最多
 * 	- 工厂方式模式：不修改已有类的前提下，通过增加新的工厂类实现扩展
 * 	- 抽象工厂模式：不可以增加产品，可以增加产品族
 * 
 * 应用场景：
 * 	- JDK中Calendar的getInstance方法
 * 	- JDBC中Connection对象的获取
 * 	- Hibernate中Sessionfactory创建Session
 * 	- spring中IOC容器创建管理bean对象
 * 	- XML解析时的DocumentBuilderFactory创建解析器对象
 * 	- 反射中Class对象的newInstance（）
 * 
 * @author jay
 *
 */
public class Client {
	public static void main(String[] args) {
		CarFactory factory = new LuxuryCarFactory();
		Engine e = factory.createEngine();
		
		e.run();
		e.start();
	}
}
