package com.jay.java.ArrayMulti;
import java.util.Arrays;
/**
 * 
 * @author jay
 * 多维数组
 *
 */


public class Test01 {

	public int[] sortMao(int[] a) {
		int temp;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length - 1 - i; j++) {
				if(a[j] > a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		return a;
	}
	public static void main(String[] args) {
		int[][] a = {
				{1,2},
				{2,3},
				{4,5,6,7}
		};
		int[][] a1 = new int[3][];
		a1[0] = new int[2];
		a1[1] = new int[2];
		a1[2] = new int[3];
		a1[0][0] = 1;
		a1[0][1] = 2;
		
		int[] b = {2,3};
		a1[1] = b;
		
		int[] c = new int[4];
		a1[2] = c;
		
		//非法命名
		// int t1[][] = new int[][4];
		int[] a2 = {1,2,323,23,543,12,59};
		Arrays.sort(a2);
		System.out.println(Arrays.toString(a2));
//		Object cc = new Object();
//		cc.toString();
		//两个toString()有没有关系
		
		//对Object进行排序，需要进行自定义compareTo(Object o)
		//有个接口
		
		//二分法查找
		System.out.println(Arrays.binarySearch(a2, 12));
		
		//填充fill	
		Arrays.fill(a2, 2,4,100);
		System.out.println(a2);
		//排序后进行查找事半功倍
		for(int i : a2) {
			System.out.println(i);
		}
		//数组的拷贝
	}
}
