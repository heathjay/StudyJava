package com.jay.java.TestDate;

import java.util.Date;

/**
 * 
 * @author jay
 *
 */
public class TestDate {
	public static void main(String[] args) {
		Date d = new Date();
		long t = System.currentTimeMillis();
		System.out.println(t);
		
		//这个数指向的时间
		Date d2 = new Date(1000);
		//横杠 @Deprecated
		System.out.println(d2.toGMTString());
		System.out.println(d2.getTime());
		System.out.println(d.before(d2));
	}
}
