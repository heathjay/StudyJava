package com.jay.jave.TestTreeSet;
import java.util.Comparator;
/**
 * TreeSet
 * - 调用构造方法的时候就应该 有排序的概念
 * - new TreeSet（） java.lang.Comparable + compareTo 
 * 	- 需要对源码进行操作 
 * - new TreeSet(Comparator<? super W> comparator) +java.util.Comparator + compare
 * 	- 解耦合
 * - TreeSet 在添加数据的时候进行排序
 * - 用final进行修饰，不能更改，如果进行修改可能会重复
 */
import java.util.TreeSet;

public class TestTreeSet {
	public static void main(String[] args) {
		Person p1 = new Person("jj", 100);
		Person p2 = new Person("jwj", 10);
		Person p3 = new Person("jaj", 120);
		Person p4 = new Person("jxj", 110);
		
		//存放
		//new TreeSet() 要求元素可以排序 
 		TreeSet<Person> persons = new TreeSet<Person>(
 				//使用业务类
 				new Comparator<Person>() {

					/* (non-Javadoc)
					 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
					 */
					@Override
					public int compare(Person o1, Person o2) {
						//升序 
						return o1.getHandsome() - o2.getHandsome();
					}
 					
 				}
 				);
 		//TreeSet在添加数据时候排序
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		System.out.println(persons);
		System.out.println(persons);
	}
}
