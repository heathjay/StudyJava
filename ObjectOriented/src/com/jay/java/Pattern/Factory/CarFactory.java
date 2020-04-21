package com.jay.java.Pattern.Factory;
/**
 * 工厂模式
 * @author jay
 *
 */
public class CarFactory {
	/**
	 * 新加一个类，需要增加一个else if
	 * 但违反了开闭原则,open-closed principle
	 * @param type
	 * @return
	 */
	public static Car createCar(String type) {
		if("Audi".equals(type)) {
			return new Audi();
		}else if("Byd".equals(type)) {
			return new Byd();
		}else {
			return null;
		}
			
	}
}
