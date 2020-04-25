package com.jay.java.RegularExpression;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {

	public static void main(String[] args) {
		//Test1();
		//Test2();
		Test3();
	}
	public static void Test1() {
		//iahfiowe823981是否符合指定的正则表达式\w+---\\w+ 
				Pattern p = Pattern.compile("\\w+");
				
				//创建matcher对象
				Matcher m = p.matcher("iahfio**we823981");
				//boolean yesorno = m.find();//查找与该模式匹配的下一个子序列
				//有没有下一个子序列find
				//调用
				/*//System.out.println(m.matches());
				System.out.println(m.find());
				System.out.println(m.group());
				
				System.out.println(m.find());
				System.out.println(m.group());*/
				
				while(m.find()) {
					System.out.println(m.group());
					System.out.println(m.group(0));//0代表整个表达式的子字串，1，2，3，捕获组
				}
				
				
	}
	
	public static void Test2() {
		Pattern p = Pattern.compile("([a-z]+)([0-9]+)");
		
		Matcher m = p.matcher("jijsji123**jisjis222**jsisj111");
		
		//分组处理
		while(m.find()) {
			System.out.println(m.group());
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
		
	}
	
	public static void Test3() {
		Pattern p = Pattern.compile("[0-9]+");
		
		Matcher m = p.matcher("jijsji123**jisjis222**jsisj111");
		
		//替换
		System.out.println(m.replaceAll("#"));
		
		//分割
		
		Pattern p1 = Pattern.compile("[0-9]+");
		
		Matcher m1 = p1.matcher("a,b,c,d");
		String[] str = "a,b,c,d".split(",");
		System.out.println(Arrays.toString(str));
		System.out.println(Arrays.toString("absiujdi17283sofio19391874sijgiaw".split("\\d+")));
		
	}
}
