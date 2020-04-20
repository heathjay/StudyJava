package com.jay.java.NestedClass;

import com.jay.java.NestedClass.TestNestedClass1.FieldInnerClass;

/**
 * 测试内部类,一般情况是为了让外部类进行使用
 * -能够生成一个独立的class
 * - 静态内部类
 * 		- bin文件夹下面TestNestedClass.class TestNestedClass$StaticNestedClass,
 * 		- 静态内部类可以包含静态成员，非静态成员
 * 		- 静态内部类可以调用直接调用外部类的静态属性、静态方法，但不能调用外部类的普通属性和普通方法
 * 		- 在不相关类中，可以直接创建静态内部类的对象，不需要通过所在外部类
 * 		- 静态内部类实际上和外部类联系很少，也就是命名空间上的联系
 * - 非静态内部咧
 * @author jay
 *
 */
public class TestNestedClass1 {
	/**
	 * 1.静态内部类
	 * 不能调用外部类的普通成员
	 * 只能调用静态成员，从属于类
	 * 在不相关类中可以直接创建内部类对象
	 * 和外部类联系很少，好像一个包一样，
	 * 外部调用的时候
	 * TestNestedClass1.StaticNestedClass ox = new TestNestedClass1.StaticNestedClass();
	 * @author jay
	 *
	 */
	int c = 5;
	static int d = 10;
	static class StaticNestedClass{
		int a = 3;
		static int b = 6;
		int x = d+a;
		
		//int y = c + a;
		//run();
	}
	public void run() {
		
	}
	
	/**
	 * 2. 非静态内部类：成员内部类
	 * - 成员内部类就像一个成员变量一样存在于外部类
	 * - 成员内部类可以访问外部类的所有成员，包括private
	 * - 成员内部类的this指向内部类对象本身，要拿到外部类对象才可以使用：外部类+.this
	 * - 成员内部类的独享一定要绑定在一个外部类的对象上，因此，创建成员内部类对象需要持有外部类对象的引用，因此，要先有外部类对象，后有成员内部类对象
	 * - 成员内部类不能有静态成员
	 * 
	 * @param args
	 */
	 class FieldInnerClass{
		
		void test() {
			System.out.println(c);
			System.out.println("内部类对象:" + this);//内部类对象依赖于外部类对象
			System.out.println("外部类对象:" + TestNestedClass1.this);//内部类对象依赖于外部类对象
			
		}
	}
	/**
	 * 2.2方法内部类
	 *	- 局部内部类
	 *	- 不能使用修饰 public private 等
	 *	- 只能在方法中可见
	 *	- 只能定义非静态成员
	 *	- 不能引用局部变量，除非是final
	 *	- 方法和堆里的对象声明周期不同，方法执行完，内部类对象可能仍然存在，
	 */
	void sayHello() {
		
		int y = 11;
		class LocalClass{
			void test() {
				System.out.println(y);
			}
		}
		
		/**
		 * 匿名内部类：
		 * 	1. 定义了匿名内部类的类体
		 * 	2. 创建了一个实例对象
		 * 	3. 大部分会在方法里面进行声明并
		 */
		Runnable runnable = new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
			
			}
			
		};
	}
	Runnable runnable = new Runnable() {
		
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	};
	public static void main(String[] args) {

	}

}

class Outer{
	public void out() {
		TestNestedClass1.StaticNestedClass ox = new TestNestedClass1.StaticNestedClass();
		TestNestedClass1 out = new TestNestedClass1();
		FieldInnerClass xx =out.new FieldInnerClass();
		
		FieldInnerClass yy = new TestNestedClass1().new FieldInnerClass();
	}
}
