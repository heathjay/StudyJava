package com.jay.java.TestDate;

import java.text.SimpleDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 * 可视化日历
 * @author jay
 * c.getActualMaximum(Calendar.DATE)
 * c.get(Calendar.DAY_OF_WEEK)
 */
public class TestViewableCalendar {
	public static void main(String[] args) {
		System.out.println("输入日期:yyyy-mm-dd");
		Scanner scanner = new Scanner(System.in);
		String temp = scanner.nextLine();		
		//String temp = "2030-5-10";
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date d = df.parse(temp);
			Calendar c = new GregorianCalendar();
			c.setTime(d);
			int CurDay = c.get(Calendar.DATE);
			//调用到1号
			c.set(Calendar.DATE, 1);
			int StartDay = c.get(Calendar.DAY_OF_WEEK);
			int MaxDate = c.getActualMaximum(Calendar.DATE);
			System.out.println("日\t一\t二\t三\t四\t五\t六");
			//visible calender
			for(int i = 0; i < StartDay-1; i++ ) {
				System.out.print("\t");
			}
			
			for(int i = 1; i <= MaxDate; i++) {
				if(i == CurDay) {
					System.out.print("*");
				}
				System.out.print(i+"\t");
				int w = c.get(Calendar.DAY_OF_WEEK);
				if(w == Calendar.SATURDAY) {
					System.out.println();
				}
				c.add(Calendar.DATE, 1);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
