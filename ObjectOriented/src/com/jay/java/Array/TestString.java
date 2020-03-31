package com.jay.java.Array;
/**
 * 
 * @author jay
 * 数组的特殊应用
 *	equals
 *	String()
 *	indexOf(int ch)
 */
public class TestString {
	public static void main(String[] args) {
		String str = "abc";
		String a = new String();
		String b = new String("abs");
		char[] c1 = {'a','b'};
		String c = new String(c1);
		System.out.println(str.charAt(2));
		// 如果是同一个对象，就是true
		String str2 = str;
		System.out.println(str2.equals(str));
		//如果不是同一个对象
		String str3 = new String("abc");
		System.out.println(str3.equals(str));
		//常量池中
		String str4 = "abca";
		System.out.println(str4 == str);
		System.out.println(str4.indexOf('a'));
		
		//split
		String str6 = "abcde,rrtt,ccceee";
		String[] array = str6.split(",");
		for(int i = 0; i < array.length;i++) {
			System.out.println(array[i]);
		}
		//trim 去除收尾空格
		String str7 = "   aa   bb";
		System.out.println(str7.trim());
		String str8 = "ABcd";
		System.out.println(str8.equalsIgnoreCase(str));
		
		//indexOf
		System.out.println("ABCs".indexOf(b));
		System.out.println("abcb".lastIndexOf(b));
		
		//startwith
		System.out.println("Abc".startsWith("b"));
		
		//endwith
		System.out.println("abcd".endsWith(b));
		//toLowerCase
		System.out.println("ABC".toLowerCase());
		
		String gh = "a";
		for(int i = 0; i < 10;i++) {
			gh += i;
		}
		//11个对象,gh指针一直在变化,
		//做服务器程序这样的资源浪费不能
		
		String gx = new String("a");
		for(int i = 0;i < 10; i++) {
			gx += i;
		}
		//12个对象，"a"一个 value:a 一个对象
		
		StringBuilder gy = new StringBuilder("a");
		for(int i = 0;i < 10; i++) {
			gy.append(i);
		}
		//两个对象
		System.out.println(gh);
	}
}
