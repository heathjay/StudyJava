package com.jay.java.Fanxing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 泛型的嵌套
 * @author jay
 * - 一层层拿开，由外岛内进行拆分，可能会用到
 * - 泛型没有多态
 * - 泛型没有数组
 * - 1.7进行简化
 * - 
 * 
 */
public class Qiantao {
	public static void main(String args[]) {
		Student<String> stu = new Student<String>();
		
		stu.setRank("good");
		System.out.println(stu.getRank());
		
		Bj<Student<String>> bj = new Bj<Student<String>>();
		bj.setStu(stu);
		stu = bj.getStu();
		System.out.println(stu.getRank());
		
		// HashMap遍历
		Map<String, String> map = new HashMap<String,String>();
		map.put("a", "shjshjs");
		map.put("b", "ggg");
		Set<Entry<String,String>> entrySet = map.entrySet();
		for(Entry<String, String> entry : entrySet) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
		}
		//泛型没有多态
		//List<Fruit> list = new ArrayList<Apple>();
		List<Fruit> list = new ArrayList<>();
		//泛型没有数组
		Fruit[] arry = new Fruit[10];
		//Fruit<String>[] arry = new Fruit<String>[10];
		//arraylist 内部还是object 数组，放的时候，拿的时候需要转化
		
	}
}
class Bj<T>{
	/**
	 * @return the stu
	 */
	public T getStu() {
		return stu;
	}

	/**
	 * @param stu the stu to set
	 */
	public void setStu(T stu) {
		this.stu = stu;
	}

	T stu;
}

class Student<T>{
	private T rank;

	/**
	 * @return the rank
	 */
	public T getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(T rank) {
		this.rank = rank;
	}
	
}
