package com.jay.java.Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 自己实现一个ArrayList
 * @author jay
 *
 */
public class MyArrayList {
	private Object[] elementData;
	private int size;
	
	public MyArrayList(int initialCapacity) {
		if(initialCapacity < 0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.elementData = new Object[initialCapacity];
		
	}
	public MyArrayList() {
		this(10);
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	private void rangeCheck(int index) {
		if(index >= this.size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Object get(int index) {
		this.rangeCheck(index);
		return this.elementData[index];
	}
	public void add(Object obj) {
		
		//数组扩容问题
		if(this.size == this.elementData.length) {
			Object[] newArray= new Object[this.size * 2];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			this.elementData = newArray;
		}
		this.elementData[size] = obj;
		this.size++;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	public void remove(int index) {
		this.rangeCheck(index);
		int numIndex = size - index -1;
		if (numIndex > 0) {
			System.arraycopy(this.elementData, index+1, elementData, index, numIndex);
		}
		this.elementData[--size] = null;
	}
	
	public void remove(Object obj) {
		for(int i = 0; i < this.size; i++) {
			if(this.get(i).equals(obj)) {
				//底层调用的是equals
				this.remove(i);
			}
		}
	}
	
	public Object set(int index, Object obj) {
		Object object = this.elementData[index];
		this.elementData[index] = obj;
		return object;
	}
	
	private void ensureCapacity() {
		if(this.size == this.elementData.length) {
			Object[] newArray= new Object[this.size * 2];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			this.elementData = newArray;
		}
	}
	public void add(int index, Object obj) {
		rangeCheck(index);
		this.ensureCapacity();
		
		System.arraycopy(this.elementData, index, this.elementData, index+1, size - index);
		this.elementData[index] = obj;
		size++;
	}
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(3);
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		System.out.println(list.getSize());
		//System.out.println(list.get(4));
		 
	}
}
