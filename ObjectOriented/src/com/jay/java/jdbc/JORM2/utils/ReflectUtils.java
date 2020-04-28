package com.jay.java.jdbc.JORM2.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author jay
 *
 */
public class ReflectUtils {
	/**
	 * 调用obj对象对应属性fieldName的get方法
	 * 
	 * @param fieldName
	 * @param obj
	 * @return
	 */
	public static Object invokeGet(String fieldName, Object obj) {
		try {
			Class c = obj.getClass();
			Method m = c.getDeclaredMethod("get" + StringUtils.firstChar2UpperCase(fieldName), null);
			return m.invoke(obj, null);
		
		} catch(Exception e) {
			return null;
		}
	
	}
	
	public static void invokeSet(Object obj, String columnName, Object columnValue) {
		try {
			if(columnValue !=null) {
				//调用rowObject 对象的setUserName方法，将columnValue的值设置进去
				Method m = obj.getClass().getDeclaredMethod("set"+StringUtils.firstChar2UpperCase(columnName), columnValue.getClass());
				m.invoke(obj, columnValue);
			}
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
