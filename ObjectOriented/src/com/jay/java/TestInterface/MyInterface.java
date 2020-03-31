package com.jay.java.TestInterface;
/**
 * 
 * @author jay
 * Test Interface
 *	接口里面有什么：
 *	常量和抽象方法
 *	不能加private 到方法前面
 *	
 *
 */
public interface MyInterface {
	//接口里面
	/*public static final 接口中常量定义时，写或不写都有*/String MAX_GREAT = "Boss";
	int MAX_SPEED = 120;
	public void test01();
	public int test02(int a, int b);
}
