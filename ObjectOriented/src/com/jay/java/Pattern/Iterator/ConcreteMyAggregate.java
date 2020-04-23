package com.jay.java.Pattern.Iterator;
/**
 * 自定义聚合类：存数据
 * @author jay
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.MapIterator;

public class ConcreteMyAggregate {
	private List<Object> list = new ArrayList<Object>();
	
	public void addObject(Object obj) {
		this.list.add(obj);
	}
	
	public void removeObject(Object obj) {
		this.list.remove(obj);
	}


	public List<Object> getList() {
		return list;
	}


	public void setList(List<Object> list) {
		this.list = list;
	}
	//使用内部类实现迭代器，直接使用外部类的属性
	private class ConcreteIterator implements MyIterator{
		
		private int cursor;//使用游标来定位
		
		@Override
		public void first() {
			cursor = 0;
		}

		@Override
		public void next() {
			if(this.cursor < list.size()) {
				cursor++;
			}
		}

		@Override
		public boolean hasNext() {
			if(this.cursor < list.size()) {
				return true;
			}
			return false;
		}

		@Override
		public boolean isFirst() {
			if(this.cursor == 0) {
				return true;
			}
			return false;
		}

		@Override
		public boolean isLast() {
			return this.cursor == (list.size()-1)?true : false;
		}

		@Override
		public Object getCurrentObj() {
			// TODO Auto-generated method stub
			return list.get(cursor);
		}
		
	}
	
	public MyIterator createIterato() {
		return new ConcreteIterator();
	}
}
