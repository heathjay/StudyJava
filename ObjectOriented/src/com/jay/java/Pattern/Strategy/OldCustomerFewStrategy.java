package com.jay.java.Pattern.Strategy;
/**
 * 其中一个算法
 * @author jay
 *
 */
public class OldCustomerFewStrategy implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("8.5");
		return standardPrice*0.85;
	}

}
