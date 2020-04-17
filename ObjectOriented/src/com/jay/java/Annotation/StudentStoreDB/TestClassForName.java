package com.jay.java.Annotation.StudentStoreDB;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 利用反射进行解析\
 * - forName获取类的所有信息
 * - 获得类的所有注解
 * 	- Annotation[] annotations=clz.getAnnotations();
 * - clz.getAnnotation(MyTable.class)
 * 	- MyTable mt = (MyTable)clz.getAnnotation(MyTable.class);
 * - mt.value()
 * 
 * 2. 获得类的属性注解
 * 	-  clz.getDeclaredFields()
 * 	-  clz.getDeclaredField("name");
 * 	- MyField mf = f.getAnnotation(MyField.class);
 * 	- mf.columnName() + mf.type() + mf.length()
 * @author jay
 *
 */
public class TestClassForName {
	public static void main(String[] args) {
		try {
			Class clz = Class.forName("com.jay.java.Annotation.StudentStoreDB.Student");
			
			//
			Annotation[] annotations=clz.getAnnotations();
			for(Annotation a : annotations) {
				System.out.println(a);
			}
			MyTable mt = (MyTable)clz.getAnnotation(MyTable.class);
			System.out.println(mt.value());
			/*Field[] f = clz.getDeclaredFields();
			System.out.println(f[0]);*/
			
			Field f = clz.getDeclaredField("name");
			MyField mf = f.getAnnotation(MyField.class);
			System.out.println(mf.columnName() + mf.type() + mf.length());
			
			//根据获得的表名字和字段信息拼出DDL语句，然后使用JDBC执行SQL，操作数据库
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
