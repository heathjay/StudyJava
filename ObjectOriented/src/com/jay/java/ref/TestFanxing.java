package com.jay.java.ref;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 泛型处理
 * - 以ParameterizedType 为例子
 * - 获取指定方法的带泛型参数
 * - 获取指定方法的返回值泛型
 * @author jay
 *
 */
public class TestFanxing {
	public void Test1(Map<String,User> map, List<User> list) {
		System.out.println("Test1");
	}
	public Map<Integer,User> test02(){
		System.out.println("test02");
		return null;
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		//带泛型的参数
		Method m = TestFanxing.class.getMethod("Test1", Map.class,List.class);
		Type[] t = m.getGenericParameterTypes();
		for(Type paramType : t) {
			System.out.println("#"+paramType);
			if(paramType instanceof ParameterizedType) {
				Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
				for(Type genericType : genericTypes) {
					System.out.println("泛型类型："+genericType);
				}
			}
		}
		//带泛型的返回值
		Method m2 =  TestFanxing.class.getMethod("test02", null);
		Type returnType = m2.getGenericReturnType();
		if(returnType instanceof ParameterizedType) {
			Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();
			for(Type genericType : genericTypes) {
				System.out.println("返回值，泛型类型"+genericType);
			}
		}
	}
}
