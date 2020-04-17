package com.jay.java.Annotation.StudentStoreDB;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 1. 修饰属性
 * 2. 对应列名
 * - 类型
 * - 长度
 * @author jay
 *
 */

@Target(value= {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyField {
	String columnName();
	String type();
	int length();
}
