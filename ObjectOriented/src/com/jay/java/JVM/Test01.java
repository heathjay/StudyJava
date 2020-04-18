package com.jay.java.JVM;
/**
 * - 加载
 * - 验证
 * - 准备
 * - 解析
 * - 初始化
 * 	- 类构造器: 赋值化动作和静态初始化块合并到类初始化方法，初始化之后才会new一个对象,赋值100，static赋值300，最后300
 * 	- 初始化顺序
 * 
 * - 内存解析：
 *		- 栈区：放对象，+方法区（特殊的堆）
 *		- 堆区 
 *-------反射的核心里面
 * - 1. 加载Test01类，在方法区有了Test01类的运行时数据：静态变量，静态方法，常量池，，类的代码
 * - 2. 堆里面有对象，java.lang.Class 对象代表Test01对象，可以通过这个对象操作Class运行时数据结构
 * - 3。 处理A：在方法区加载了A的运行时数据结构：静态变量，静态方法，常量池，类的数据结构，通过也会在堆里面形成代表Aclass对象
 * -----------
 * 加载完之后才真正开始执行代码
 * 1. main（）方法的一个栈，main的栈祯，
 * 2. 调用构造器，压入栈中，在堆中生成以个A的对象，A对象的地址会赋给a，a拥有了对象的地址
 * 3. 如果父类没有静态初始化，优先静态初始化父类,始终会先初始化Object,类加载的初始化只会有一次，不需要进行反复加载
 * 4. 类加载完成之后，链接成功后，调用static{}方法调用<clinit>方法
 * 
 * System.out.println(A.width);
 * 1. 类的主动引用（一定会发生类的初始化）
  - new 一个类的对象
  - 调用类的静态成员，但是调用常量不需要主动引用
  - 使用java.lang.reflect包的方法对类进行反射调用
  - 当虚拟机启动，java Hello则一定会初始化Hello类，启动main方法所在的类
  - 当初始化一个类，如果其父类没有被初始化，则先会初始化他的父类
  
2. 类的被动
  - 当访问一个静态域时，只有真正声明这个域的类才会被初始化
    - 通过子类引用父类的静态变量，不会导致子类初始化
  - 通过数组定义类引用，不会触发此类的初始化
  - 引用常量不会出发此类的初始化(常量在编译阶段就存入调用类的常量池中)
 * 
 * @author jay
 *
 */
public class Test01 {
	static {
		System.out.println("Test01");
	}
	public static void main(String[] args) throws ClassNotFoundException {
	/*	A a = new A();
		System.out.println(A.width);*/
		
		//主动加载
		new A();
		System.out.println(A.width);
		Class.forName("com.jay.java.JVM.A");
		
		//被动
		System.out.println(A.MAX);
		A[] as = new A[1];
		System.out.println(B.width);//子类访问父类的成员变量，父类初始化，子类不是真正初始化
	}
}
class B extends A{
	static {
		System.out.println("B");
	}
}
class A extends Father{
	public static int width=100;	//静态变量，静态域 field
	public static final int MAX = 100;
	static{
		System.out.println("静态初始化A");
		width = 300;
	}
	public A() {
		System.out.println("创建A");
	}
}

class Father {
	static {
		System.out.println("Father");
	}
}
