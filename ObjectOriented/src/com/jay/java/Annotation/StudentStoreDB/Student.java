package com.jay.java.Annotation.StudentStoreDB;
/**
 * 存储类
 * @author jay
 *	1. 定义注解
 *	2. 通过类读取注解tb_student 
 *	3. 解析程序读取注解进行处理
 *		- 通常有框架做好了，使用就可以了
 *		- 使用反射，进行模式
 */
@MyTable("tb_student")
public class Student {
	@MyField(columnName="sname", length = 10, type = "varchar")
	private String name;
	@MyField(columnName="age", length = 3, type = "int")
	private int age;
	@MyField(columnName="id", length = 10, type = "int")
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
