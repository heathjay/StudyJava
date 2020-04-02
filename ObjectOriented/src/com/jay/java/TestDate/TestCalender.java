package com.jay.java.TestDate;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * @author jay
 * Calender 类
 * Long 和 时间类型的换算
 * 月份算法是1月为0；
 * 周日为1，周一为1；
 * 日期计算
 * field
 * 常量 YEAR,MONTH, WEEK, 
 * Calendar.YEAR
 * c.set
 * c.get
 * c.add
 */
public class TestCalender {
	public static void main(String[] args) {
		Calendar c = new GregorianCalendar();//Calendar是一个抽象类，需要调用子类的应用
		c.set(2011, 11, 10, 12, 22, 22);
		Date d = c.getTime();
		System.out.println(d);
		
		c.set(Calendar.YEAR, 2011);
		c.set(Calendar.MONTH, 2);
		c.set(Calendar.DATE, 22);
		 d = c.getTime();
		c.setTime(new Date(1000));
		
		c.add(Calendar.YEAR, 33);
		c.add(Calendar.YEAR, -33);
		System.out.println(d);
		System.out.println(c);
		System.out.println(c.get(Calendar.YEAR));
	}
}
