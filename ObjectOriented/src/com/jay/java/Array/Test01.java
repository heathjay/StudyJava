package com.jay.java.Array;
/**
 * 
 * @author jay
 * 1. 声明数组
 * 2. 数组也是对象，也是引用类型
 * 3. 需要进行初始化
 * 4. 长度确定不可变
 * 5. 遍历
 */
public class Test01 {
	public static void main(String[] args) {
		int array[] = new int[3];
		array[0] = 1;
		Car[] car = new Car[6];
		car[0] = new Car("bmw");
		System.out.println(car[0].name);
		System.out.println(array.length);
	}
}
