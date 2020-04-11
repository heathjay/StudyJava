package com.jay.java.Sort;
/**
 *  排序规则的业务类
 *  
 * @author jay
 *
 */
public class jTestComparator implements java.util.Comparator<String>{
	/*
	 * 	按照度比较
	 * 正数>
	 * 负数<
	 * 0 ==
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(String o1, String o2) {
		int len1= o1.length();
		int len2 = o2.length();
		return len1 - len2;
	}
	
}
