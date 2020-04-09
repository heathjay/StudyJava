package com.jay.java.Iterator;

import java.util.Arrays;
import java.util.Iterator;


/**
 * iterator直接放到方法里面
 * - 匿名内部类
 * - 加入add方法
 * - ArrayList 增强for循环 
 * - 使用Iterable 接口可以用于增强for循环
 * @author jay
 *
 */
public class TestIterator3 implements java.lang.Iterable{
	//private String[] elem = {"a", "b","c"};
	private String[] elem = new String[5];
	//private int size = elem.length;
	private int size = 0;
	//计数器 游标指针
	//面向接口编程
	
	public void add(String ele) {
		if (this.size == elem.length) {
			elem = Arrays.copyOf(elem, elem.length + 5);
		}
		elem[size] = ele;
		size++;
	}
	private class MyIterator implements Iterator{
		private int cursor = -1;
		public boolean hasNext() {	
			return cursor + 1 < size;
		}
		
		public String next() {
			cursor++;
			return elem[cursor];
		}
		
		public void remove() {
			System.arraycopy(elem, cursor+1, elem, cursor, TestIterator3.this.size - cursor -1);
			TestIterator3.this.size--;
			this.cursor--;
		}
	}
	public int size() {
		return this.size;
	}
	
	public Iterator iterator() {
		return new MyIterator();
	}
	
	public Iterator iterator2() {
		class MyIter implements Iterator{
			private int cursor = -1;
			public boolean hasNext() {	
				return cursor + 1 < size;
			}
			
			public String next() {
				cursor++;
				return elem[cursor];
			}
			
			public void remove() {
				System.arraycopy(elem, cursor+1, elem, cursor, TestIterator3.this.size - cursor -1);
				TestIterator3.this.size--;
				this.cursor--;
			}
		}
		return new MyIter();
	}
	
	//使用匿名内部类
	public Iterator iterator3() {
		return new Iterator() {
			//创建迭代器接口实现类的对象，匿名
			private int cursor = -1;
			public boolean hasNext() {	
				return cursor + 1 < size;
			}
			
			public String next() {
				cursor++;
				return elem[cursor];
			}
			
			public void remove() {
				System.arraycopy(elem, cursor+1, elem, cursor, TestIterator3.this.size - cursor -1);
				TestIterator3.this.size--;
				this.cursor--;
			}
		};
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestIterator3 list = new TestIterator3();
//		Iterator it = list.iterator();
//		//先判断后获取
//		while(it.hasNext()) {
//			System.out.println(it.next());
//			it.remove();
//		}
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("c1");
		list.add("c2");
		list.add("c3");
		Iterator it2 = list.iterator2();
		while(it2.hasNext()) {
			System.out.println(it2.next());
			//it2.remove();
		}
		for(Object str:list) {
			System.out.println((String)str);
		}
		System.out.println(list.size());
	}
}
