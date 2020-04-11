package com.jay.java.CollectionQueueHashTable;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * 类似迭代器
 * Enumeration b
 * hasMoreElements(
 * nextElement - Next
 * - 有一个实现类
 * 	- StringTokenizer
 * 	- String split 方法相类似，用于字符串的分割，但不支持正则表达式
 * Vector的element方法	
 * @author jay
 *
 */
public class TestEnumeration {
	public static void main(String[] args) {
		//TestE();
		TestStringTokenizer();
		
		
		
	}
	
	public static void TestStringTokenizer() {
		String email = "bajsjfsij@163.com;jsi@gmail.com;jsisji@mail.com";
		StringTokenizer tk = new StringTokenizer(email,";");
		while(tk.hasMoreElements()) {
			System.out.println(tk.nextElement());
		}
	}
	
	public static void TestE() {
		Vector<String>	vector = new Vector<String>();
		vector.add("jajva");
		vector.add("jaj");
		vector.add("jsva");
		
		//遍历
		Enumeration<String> en =  vector.elements();
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		
	}
}
