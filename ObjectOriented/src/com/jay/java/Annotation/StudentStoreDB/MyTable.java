package com.jay.java.Annotation.StudentStoreDB;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义注解
 * - 修饰类，
 * 
 * @author jay
 *
 */

@Target(value= {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTable {
	String value();
}
