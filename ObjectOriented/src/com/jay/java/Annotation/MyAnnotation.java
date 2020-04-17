package com.jay.java.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 关键字: @interface
 * - 需要加上两个原注解，用来对注解做解释
 * - @target
 * 	- 作用： 用来描述注解的使用范围，
 * 		- package - package
 * 		-类/接口/枚举/annotation - TYPE
 * 		- 类型成员： 方法，构造器，成员变量，枚举值  - constructor 构造器 field method
 * 		- 方法参数和本地比纳凉， local variable
 * -@Retation
 * 	- 保留注释信息，用来描述注解的生命周期
 * 		- source - 源文件
 * 		- class class文件有用
 * 		-runtime 运行时有效，为Runtime可以被反射机制读取
 *  
 *  - 注解参数类型和参数名称。可以用default " " 或者null
 *  - 默认值如果是-1的话，表示不存在
 *  - 如果只有一个参数，通常命名为value()
 * @author jay
 *
 * 
 * */


@Target(value= {ElementType.METHOD,ElementType.TYPE,ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String studentName() default " ";	//注解里面包含的是参数信息，参数名，参数类型
	int age() default 0;
	String[] schools() default{};
}
