package com.jay.java.Sort;
/**
 * 冒泡排序
 * @author jay
 *
 */
public class BubbleSort1 {
	public static void main(String[] args) {
		int[] arr = {9, 8 ,7 , 6, 5};
		//第一个版本有些已经被交换过,
		sort1(arr);
		print(arr);
	
		int[] arr1 = {9, 8 ,7 , 6, 5};
		sort2(arr1);
		print(arr1);
		
	}
	public static void print(int[] arr) {
		for(int i : arr) {
			System.out.println(i);
		}
	}
	public static void sort1(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length - i - 1; j++) {			
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	//减少唐数，通过判断
	public static void sort2(int[] arr) {
		boolean sorted = true;
		int len = arr.length;
		for(int i = 0; i < len - 1; i++) {
			sorted = true;//假定有序
			
			for(int j = 0; j < arr.length - i - 1; j++) {			
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted= false;
				}
			}
			if(sorted) {
				break;
			}
		}
	}
}
