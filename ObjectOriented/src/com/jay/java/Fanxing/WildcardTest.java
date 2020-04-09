package com.jay.java.Fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * 通配符类型不确定
 * @author jay
 *	声明在变量上面,或者形参
 * 1. 只能用在声明上面
 * 2. 不能用在泛型类声明，不能用于创建对象
 * 泛型的上限，用？和extends搭配，传过来的值是实现类
 * - extends 泛型上限 <= 子类及自身
 * - ? 等同于extends Object
 * - 具体引用实现根据后面new
 * - 用于限制操作，容器，对象，不能使用在添加数据上面，一般都是对数据的读取操作
 * - list.add(new Apple())不行
 * - 规则
 *  List<? extends Fruit>---- List<Fruit>, List<Apple> 
 *  
 *  3. 下限 super >= 父类或者自身
 *  - 可以添加信息，list.add(new Apple()); 但是不能添加一个父对象
 *  - 规则
 *  	- List<Fruit> -- > List<? super Apple>
 *  	- List<Apple> -- > List<? super Apple>
 *  	- List<? super Fruit> --> List<? super Apple> 
 */
public class WildcardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<?> list = new ArrayList<Integer>();
		list = new ArrayList<String>();
		list = new ArrayList<Object>();
		//test(list);
		
		
		Test<Fruit> t1 = new Test<Fruit>();
		Test<Apple> t2 = new Test<Apple>();
		Test<Pear> t3 = new Test<Pear>();
		
		List<? extends Fruit> list1 = new ArrayList<Fruit>();
		test(list1);
		List<Fruit> list2 = new ArrayList<Fruit>();
		List<Apple> list3 = new ArrayList<Apple>();
		List<? extends Fruit> list4 = new ArrayList<Fruit>();
		
		List<?> list5 = new ArrayList<Fruit>();
		
		//super
		List<Apple> list51 = new ArrayList<Apple>();
		Test2(list51);
		List<Fruit> list52 = new ArrayList<Fruit>();
		Test2(list52);
		List<Object> list53 = new ArrayList<Object>();
		Test2(list53);
		List<? super Apple> list54 = new ArrayList<Fruit>();
		List<? super Apple> list55 = new ArrayList<Object>();
		List<? super Apple> list56 = new ArrayList<Apple>();
		List<?> list57 = new ArrayList<Apple>();
		//子类不行，无下限的也不行
		//Test2(list57);
		
	}
	public static void test(List<? extends Fruit> list) {
		//不能添加任何对象
		//list.add(new Apple());
	}
	//public static <?> void test(List<T> list){}
	static class Test<T extends Fruit>{
		//extends 为上限

	}
	public static void Test2(List<? super Apple> list){
		//不能添加父类信息
		list.add(new Apple());
	}
}
//不能
//class T <?>{}
class Fruit{
	
}

class Apple extends Fruit{
}

class Pear extends Fruit{
	
}

class FushiApple extends Fruit{
	
}