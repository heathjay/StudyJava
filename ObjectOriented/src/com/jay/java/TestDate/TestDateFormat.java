package com.jay.java.TestDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author jay
 * DateFormat
 */
public class TestDateFormat {
	public static void main(String[] args) {
		//只能这么进行声明
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		//DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		Date d = new Date(123911L);
		//时间对象变字符串
		String str = df.format(d);
		System.out.println(str);
		
		//字符串转成时间对象
		String str1 = "1999-12-11 01:22:55";
		DateFormat df2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			Date d1 = df2.parse(str1);
			System.out.println(d1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
