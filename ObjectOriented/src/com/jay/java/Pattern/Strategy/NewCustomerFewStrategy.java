package com.jay.java.Pattern.Strategy;
/**
 * 其中一个算法
 * @author jay
 *
 */
public class NewCustomerFewStrategy implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("9");
		return standardPrice*0.9;
	}

}
