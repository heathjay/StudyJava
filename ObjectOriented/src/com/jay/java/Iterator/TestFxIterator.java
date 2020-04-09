package com.jay.java.Iterator;

import java.util.Arrays;
import java.util.Iterator;


/**
 * 加入泛型
 * @author jay
 *
 */
public class TestFxIterator<E> implements java.lang.Iterable<E> {
	//private String[] elem = {"a", "b","c"};
		private Object[] elem = new Object[5];
		//private int size = elem.length;
		private int size = 0;
		//计数器 游标指针
		//面向接口编程
		
		public void add(E ele) {
			if (this.size == elem.length) {
				elem = Arrays.copyOf(elem, elem.length + 5);
			}
			elem[size] = ele;
			size++;
		}
		
		public int size() {
			return this.size;
		}

		
		//使用匿名内部类
		public Iterator<E> iterator() {
			return new Iterator<E>() {
				//创建迭代器接口实现类的对象，匿名
				private int cursor = -1;
				public boolean hasNext() {	
					return cursor + 1 < size;
				}
				
				public E next() {
					cursor++;
					return (E)elem[cursor];
				}
				
				public void remove() {
					System.arraycopy(elem, cursor+1, elem, cursor, TestFxIterator.this.size - cursor -1);
					TestFxIterator.this.size--;
					this.cursor--;
				}
			};
		}
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			TestFxIterator<String> list = new TestFxIterator<String>();
//			Iterator it = list.iterator();
//			//先判断后获取
//			while(it.hasNext()) {
//				System.out.println(it.next());
//				it.remove();
//			}
			list.add("a");
			list.add("b");
			list.add("c");
			list.add("c1");
			list.add("c2");
			list.add("c3");
			Iterator it2 = list.iterator();
			while(it2.hasNext()) {
				System.out.println(it2.next());
				//it2.remove();
			}
			for(Object str:list) {
				System.out.println((String)str);
			}
			System.out.println(list.size());
			
			TestFxIterator<Integer> list2 = new TestFxIterator<Integer>();
			list2.add(1);
			list2.add(2);
			list2.add(3);
			list2.add(4);
			Iterator it = list2.iterator();
			for(Object i: list2 ) {
				System.out.println((Integer)i);
			}
			while(it.hasNext()) {
				System.out.println(it.next());
				//it2.remove();
			}
		}
}
