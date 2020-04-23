package com.jay.java.Pattern.Strategy;
/**
 * 其中一个算法
 * @author jay
 *
 */
public class OldCustomerManyStrategy implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("8");
		return standardPrice*0.8;
	}

}
