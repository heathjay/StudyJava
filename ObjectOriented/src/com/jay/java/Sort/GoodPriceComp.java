package com.jay.java.Sort;
/**
 * java.util.comparator
 * @author jay
 *
 */
public class GoodPriceComp implements java.util.Comparator<Good>{

	@Override
	public int compare(Good o1, Good o2) {
		// TODO Auto-generated method stub
		//默认是升序的
		//正数大
		//0等
		//负数小
		return o1.getPrice() - o2.getPrice() > 0 ? 1 : (o1.getPrice()==o2.getPrice() ? 0 : -1);
	}

}
