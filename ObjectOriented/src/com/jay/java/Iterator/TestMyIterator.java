package com.jay.java.Iterator;

import java.util.Iterator;

/**
 * 使用内部类进行封装
 * - 面向接口编程
 * 
 * - 把内部类放到方法里面
 * @author jay
 *
 */
public class TestMyIterator {
	private String[] elem = {"a", "b","c"};
	private int size = elem.length;
	//计数器 游标指针
	//面向接口编程
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
			System.arraycopy(elem, cursor+1, elem, cursor, TestMyIterator.this.size - cursor -1);
			TestMyIterator.this.size--;
			this.cursor--;
		}

	}
	public int size() {
		return this.size;
	}
	
	public Iterator iterator() {
		return new MyIterator();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMyIterator list = new TestMyIterator();
		Iterator it = list.iterator();
		//先判断后获取
		while(it.hasNext()) {
			System.out.println(it.next());
			it.remove();
		}
		System.out.println(list.size());
	}
}
