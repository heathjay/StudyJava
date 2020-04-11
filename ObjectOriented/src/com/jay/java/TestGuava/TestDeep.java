package com.jay.java.TestGuava;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

/**
 * 统计单词出现次数
 * - HashMap
 * 	- 1.HashMap分拣存储+面向对象思维 --> 判断
 * 	- 2. Multiset:
 * 		- 无序可重复，.count()增强了可读性，非常方便和使用
 * - 3. MultiMap:
 * 		-分析查看教师教授的每门课程
 * 		key-value, key 可以重复
 * - 4. HashMap 键值唯一，值可以重复
 * BiMap- 双向map， unique - valued map
 * 根据邮箱找用户，根据用户找邮箱
 * 
 * - 5.双键的map
 * 	Table类
 * 	- 所有的行数据CellSet()
 * 	- 所有的学生 rowKeySet()
 * 	- 所有的课程 columnKeySet()
 *  - 所有成绩 values()
 *  - 学生对应的课程 rowMap() + get(学生) 
 *  + row(学生)
 *  - 课程对应对的 columnMap() + get(课程)	 + column(课程)
 * @author jay
 *
 */
public class TestDeep {

	public static void main(String[] args) {
		TestMultimap();
		TestBiMap();
		TestTable();
	}
	
	public static void TestTable() {
		//双键，row_Key, col_Key, value
		Table<String,String,Integer> tables = HashBasedTable.create();
		tables.put("a", "jay", 11);
		tables.put("a", "jy", 211);
		tables.put("b", "jay", 111);
		tables.put("b", "jy", 131);
		tables.put("c", "jay", 112);
		tables.put("c", "y", 1111);
		//所有行数据
		Set<Cell<String,String,Integer>> cells= tables.cellSet();
		//set可以使用迭代器
		for(Cell<String,String,Integer> temp : cells) {
			System.out.println(temp.getRowKey() + "--->" + temp.getColumnKey() +"--->" + temp.getValue());
		}
		
		System.out.println("--------");
		System.out.print("学生\t");
		
		Set<String> cours = tables.columnKeySet();
		for(String tem : cours) {
			System.out.print(tem + "\t");
		}
		System.out.println();
		Set<String> stus = tables.rowKeySet();
		for(String stu : stus) {
			System.out.print(stu + "\t");
			Map<String,Integer> map = tables.row(stu);
			for(String c :cours) {
				System.out.print(map.get(c) + "\t");
			}
			System.out.println();
		}
		System.out.println("--------");
		System.out.print("课程\t");
		
		Set<String> stuSet = tables.rowKeySet();
		for(String tem : stuSet) {
			System.out.print(tem + "\t");
		}
		System.out.println();
		Set<String> coursSet = tables.columnKeySet();
		for(String c : coursSet) {
			System.out.print(c + "\t");
			Map<String,Integer> map = tables.column(c);
			for(String s :stuSet) {
				System.out.print(map.get(s) + "\t");
			}
			System.out.println();
		}
	}
	
	
	public static void TestBiMap() {
		BiMap<String,String> bimap= HashBiMap.create();
		bimap.put("ssss", "jiajia@163.com");
		bimap.put("ssaaas", "jia@163.com");
		//通过邮箱找用户
		String user = bimap.inverse().get("jia@163.com");
		System.out.println(user);
		
		
	}
	public static void TestMultiSet() {
		// TODO Auto-generated method stub
				String str = "this is a cat and this is a mice where is the food";
				String[] strArr	= str.split(str);
				//存储在Multiset中
				Multiset<String> set = HashMultiset.create();
				for(String tmp : strArr) {
					set.add(tmp);
				}
				
				//获取所有单词的set
				Set<String> letters = set.elementSet();
				for(String tmp :letters) {
					System.out.println(tmp  + "--->" + set.count(tmp));
				}
	}
	
	public static void TestMultimap() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("sss", "jijisji");
		map.put("sqs", "jsji");
		map.put("sas", "jiisji");
		map.put("sxas", "jisji");
		map.put("ssdds", "jisji");
		
		//分析
		Multimap<String,String> teachers = ArrayListMultimap.create();
		Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			
			
			//对调
			teachers.put(value, key);
		}
		
		Set<String> keyset	= teachers.keySet();
		for(String key : keyset) {
			Collection<String> col = teachers.get(key);
			System.out.println(key + "---" + col);
		}
	}

}
