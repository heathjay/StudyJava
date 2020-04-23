package com.jay.java.Pattern.Strategy;
/**
 * 其中一个算法
 * @author jay
 *
 */
public class NormalCustomerManyStrategy implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("不打折，原价");
		return standardPrice;
	}

}
