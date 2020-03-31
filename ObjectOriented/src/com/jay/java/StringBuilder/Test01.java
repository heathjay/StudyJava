package com.jay.java.StringBuilder;
/**
 * 
 * @author jay
 * 可变字符序列
 * StringBUilder 线程不安全，效率高，一般用它 / StringBuffer- 线程安全，效率低
 *	String 不可变字符序列
 */
public class Test01 {
	public static void main(String[] args) {
		//StringBuilder sb = new StringBuilder(); //长度16
		//StringBuilder sb = new StringBuilder(19); //capacity
		StringBuilder sb = new StringBuilder("abcd");// super(str.length() + 16);
		// super(str.length() + 16);
		//32长度，value[] = {'a', 'b', 'c', 'd', \u0000, \u0000...}
		sb.append("efg");
		sb.append(true).append(321).append("xxx");//调用完后返回this，返回的还是sb
		System.out.println(sb);
		sb.delete(1, 2);
		sb.reverse();
		System.out.println(sb);
		
		StringBuffer sb2 = new StringBuffer();
	}
}
