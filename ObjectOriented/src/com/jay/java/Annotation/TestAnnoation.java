package com.jay.java.Annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Annotation
 * 1. 内置注解
 * 	- 默认继承Object
 * 	- Object.toString 重写 override注解，如果toString方法名写错，会报错
 * 	- @Override
 * - @Deprecated
 * - @SuppressWarnings(value = { "uncheked","deprecation" })
 * 		- 参数包括：
 * 			- deprecation 使用了过时的类或者方法的警告
 * 			- unchecked 执行了未检查的转换时的警告，如使用集合时未指定泛型
 * 			- fallthrough 当在switch语句中使用了case穿透
 * 			- path 在类路径，源文件路径中有不存在路径的警告
 * 			- serial 当在可序列化的类上缺少serialVersionUID定义时的警告
 * 			- finally 任何finally字句不能完成时的警告
 * 			- all 关于以上所有情况的警告
 * - 范围@target
 *  
 * 2. 自定义注解
 * 
 * 
 * @author jay
 *
 */
public class TestAnnoation {
	
	//public String tostring() { 没有Override注解，不会报错
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Deprecated
	public static void test() {
		System.out.println("test ");
	}
	
	@SuppressWarnings(value = { "uncheked","deprecation","all" })
	public static void test2() {
		List<String> list = new ArrayList<String>();
	}
	@MyAnnotation(age=19,studentName="xx")//后期通过其他程序进行读取
	public static void test3() {
		
	}
	public static void main(String[] args) {
		
	}
}
