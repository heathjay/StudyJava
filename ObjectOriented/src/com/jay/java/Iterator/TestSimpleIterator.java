package com.jay.java.Iterator;
/**
 * 迭代器使用
 * 实现迭代器三个方法
 * - remove
 * - next()
 * - add（）
 * 2.封装成内部类
 * @author jay
 *
 */
public class TestSimpleIterator {
	private String[] elem = {"a", "b","c"};
	private int size = elem.length;
	//计数器 游标指针
	private int cursor = -1;


	public boolean hasNext() {	
		return cursor + 1 < size;
	}
	
	public String next() {
		cursor++;
		return elem[cursor];
	}
	
	public void remove() {
		System.arraycopy(elem, cursor+1, elem, cursor, this.size - cursor -1);
		this.size--;
		this.cursor--;
	}
	public int size() {
		return this.size;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSimpleIterator list = new TestSimpleIterator();
		//先判断后获取
		while(list.hasNext()) {
			System.out.println(list.next());
			list.remove();
		}
		System.out.println(list.size());
	}

}
