package com.jay.java.TestGuava;

import static com.google.common.collect.Sets.newHashSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;;

/**
 * - 只读设置
 * - 函数编程、
 * 	- Predicate
 * 	- Collection2.filter - 过滤
 * 	- Collections2.transform
 * - 组合式函数编程
 * 	- Functions.compose()
 * - 解耦合
 * - 加入约束条件，如果非空，长度验证 Constraint
 * - 集合的操作： 交集，并集
 * 	- 	SetView<Integer> intersection = Sets.intersection(sets, sets1);
 * 	- 差集：
 * 
 * 
 * @author jay
 *
 */
public class TestGua {
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("s");
		list.add("a");
		//snapshot of List
		List<String> readList = Collections.unmodifiableList(list);
		list.add("c");
		//list改变也会改变snapshot不够安全
		
		
		//对比查看
		//初始化List
		//并且这个List不能被改变,安全性和可靠性，
		List<String> immutableList	= ImmutableList.of("a", "b" ,"c");
		
		//创建一个List并且静态初始化
		List<String> list2 = Lists.newArrayList("momo", "sjshs","hiuwyhiuq","dad");
		//匿名内部类，只使用一次，
		//找出回文- backwords, mirror words
		Collection<String> palindromeList = Collections2.filter(list2, new Predicate<String>() {

			@Override
			public boolean apply(String input) {
				//业务逻辑-
				return new StringBuilder(input).reverse().toString().equals(input);
			}
			
		});
		
		for(String tmp : palindromeList) {
			System.out.println(tmp);
		}
		
		Set<Long> set = Sets.newHashSet();
		set.add(100010122L);
		set.add(1000101L);
		set.add(10001L);
		
		Collection<String> setA = Collections2.transform(set, new Function<Long,String>() {

			@Override
			public String apply(Long input) {
				// TODO Auto-generated method stub
				return new SimpleDateFormat("yyyy-mm-dd").format(input);
			}
			
		});
		
		for(String temp :setA) {
			System.out.println(temp);
		}
		
		
		//组合式编程
		//确保容器中的字符串长度不超过5，超过进行截取，后全部大写
		List<String> list5 = Lists.newArrayList("shhshs","ssss","qqqqq");
		//确保容器中的字符串长度不超过5，超过进行截取
		Function<String,String> f1 = new Function<String,String>() {
			@Override
			public String apply(String input) {
				// TODO Auto-generated method stub
				return input.length() > 5 ? input.substring(0,5):input;
			}
		};
		//转换成大些
		Function<String,String> f2 = new Function<String,String>() {
			@Override
			public String apply(String input) {
				// TODO Auto-generated method stub
				return input.toUpperCase();
			}
		};
		
		//组合使用String = f2(f1(String))
		Function<String,String> f = Functions.compose(f1, f2);
		Collection<String> resultC = Collections2.transform(list5, f);
		for(String temp :resultC) {
			System.out.println(temp);
		}
		
		Set<Integer> sets = Sets.newHashSet(1,2,3,4,5,6,7);
		Set<Integer> sets1 = Sets.newHashSet(1,2,3);
		
		SetView<Integer> intersection = Sets.intersection(sets, sets1);
		System.out.println(intersection);
		SetView<Integer> diff = Sets.difference(sets, sets1);
		System.out.println(diff);
		SetView<Integer> unit = Sets.union(sets, sets1);
		System.out.println(unit);
		
	
		
	}
}
