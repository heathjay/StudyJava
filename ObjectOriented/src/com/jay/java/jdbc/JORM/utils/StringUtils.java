package com.jay.java.jdbc.JORM.utils;
/**
 * 1. 为JavaFileUtils提供字符串的转换
 * @author jay
 *
 */
public class StringUtils {
	/**
	 * 将目标字符串首字母变为大写
	 * @param str
	 * @return 首字母编程大写
	 */
	public static String firstChar2UpperCase(String str) {
		//abcd--->Abcd
		return str.toUpperCase().substring(0, 1) + str.substring(1);
	}
}
