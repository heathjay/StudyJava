package com.jay.java.TestCommonsCollections;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.SwitchTransformer;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.functors.WhileClosure;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/**
 * Apache Commons Collections B
 * 函数编程之 Predicate 断言
 * 封装条件或者判别式 if else 的替代
 * 1. new EqualPredicate<T>(值)
 * 		EqualPredicate.equals
 * 2. PredicatedXxx.predicatedXxx（容器，判断）
 * 3. UniquePredicate.uniquePredicate();
 * 4. 自定义:
 * 		PredicateUtils.allPredicate(>2） andPredicate(2 &) anyPredicate 
 * 5. 判断和容器操作进行解耦合
 * 
 * - Transformer 类型转化
 * 	- transform 对象，重写transform方法
 * - Empolyee 收入转换成level
 * 	- Predicate<Employee> isHigh = new Predicate<Employee>()
 * 	- Transformer<Employee, Level> HighTrans = new Transformer<Employee,Level>()
 * 	- Transformer switchTrans = new SwitchTransformer(pre,trans,null);
 * 	- Collection<Level> levelList = CollectionUtils.collect(list,switchTrans);
 * 
 * 6. Closure 闭包
 * 	- 全部操作
 * 		- Closure<Employee> cols = new Closure<Employee>()
 * 		- CollectionUtils.forAllDo(list, cols);
 * 
 * 7. 商品打折
 * 		- Closure<Goods> ifClo = IfClosure.ifClosure(pre, discount,subtract);
		CollectionUtils.forAllDo(list, ifClo);
	-Closure<Goods> subtract = new Closure<Goods>() {
		- 需要断言:
			-功能1，
			- 功能2
			
 * 8. whileClosure
 * 9. chaindChosure.chainedClosure
 * 
 * 
 * 10. 集合的操作
 * - 交集Collection<Integer> col1 = CollectionUtils.intersection(set, set1);
 * - 差集
 * - 并集Collection<Integer> col = CollectionUtils.union(set, set1);
 * 
 * 11.队列的扩展
 * 	- 循环队列FIFO
 * 	CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
 * 	- 只读队列
 * 	Queue<String> readOnlyQue = UnmodifiableQueue.unmodifiableQueue(que);
 * 
 * 12. 迭代器的扩展
 * 	- MapIterator 以后不再使用map.keySet.iterator访问
 * 		- IterableMap HashedMap
 * IterableMap<String,String> map = new HashedMap<String,String>();
 * MapIterator<String,String> it = map.mapIterator();
 * 
 * 13.去重复迭代器
 * 	- Iterator<String> it = new UniqueFilterIterator(list.iterator()); 
 * 	- 去重复重复器，过滤器
 * 	- 自定义过滤器 FilterIterator
 * 	Iterator<String> it22= new FilterIterator(list.iterator(),pre);
 * 
 * 14.循环迭代器LoopingIterator
 * 	15.数组迭代器 ArrayListIterator
 * 	16.双向map 要求键值和值都不能重复
 * 	- BidiMap
 * -DualTreeBidiMap: 有序
 * - DualHashBidiMap:无序
 * 17. Bag包允许重复
 * 	- HashBag 无序
 * 	- TreeBag
 * 	- 用来统计单词出现次数
 * @author jay
 *
 */
public class TestCommonsCollections {
	public static void main(String[] args) {
//		ifClosure();
//		updateSalary();
//		SetFunc();
//		TestQue();
		//TestIterator();
		//TestUniqueIter();
		//TestBidiMap() ;
		//TestBag();
		getAmount();
	}
	/**
	 * bag用来统计单词出现次数
	 */
	
	public static void getAmount() {
		String str = "this is a cat and this is a mice and where is the find";
		String[] arr = str.split(" ");
		
		Bag<String> bag = new TreeBag<String>();
		for(String tmp : arr) {
			bag.add(tmp);
		}
		
		System.out.println("统计次数");
		Set<String> keys = bag.uniqueSet();
		for(String letters:keys) {
			System.out.println(letters + "-" + bag.getCount(letters));
		}
	}
	/*
	 * 包Bag
	 */
	public static void TestBag() {
		System.out.println("无序bag");
		
		Bag<String> bag = new HashBag<String>();
		bag.add("a");
		bag.add("a",5);
		bag.add("b");
		bag.add("c",2);
		
		Iterator<String> it = bag.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("有序bag");
		
		Bag<String> bag2 = new TreeBag<String>();
		bag2.add("a");
		bag2.add("a",5);
		bag2.add("b");
		bag2.add("c",2);
		
		Iterator<String> it2 = bag2.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
	}
	/**
	 * 双向map
	 */
	
	public static void TestBidiMap() {
		System.out.println("TestBidiMap");
		System.out.println("无序DualHashBidiMap");
		BidiMap<String,String> map = new DualHashBidiMap<String,String>();
		map.put("jisjisji", "jsijsijsijsissi");
		map.put("sji", "jsijsijsiai");
		
		//可以通过值找到键位，可以反查找
		//但是需要反转
		System.out.println(map.inverseBidiMap().get("jsijsijsijsissi"));
		
		//遍历查看
		MapIterator<String,String> it = map.inverseBidiMap().mapIterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = it.getValue();
			System.out.println(key + "--->" + value);
		}
		
		/**
		 * 有序双向
		 */
		
		System.out.println("DualTreeBidiMap");
		BidiMap<String,String> map1 = new DualTreeBidiMap<String,String>();
		map1.put("jisjisji", "jsijsijsijsissi");
		map1.put("sji", "jsijsijsiai");
		
		//可以通过值找到键位，可以反查找
		//但是需要反转
		System.out.println(map1.inverseBidiMap().get("jsijsijsijsissi"));
		
		//遍历查看
		MapIterator<String,String> it1 = map1.inverseBidiMap().mapIterator();
		while(it1.hasNext()) {
			String key = it1.next();
			String value = it1.getValue();
			System.out.println(key + "--->" + value);
		}
	}
	/**
	 * 去重复迭代器
	 */
	public static void TestUniqueIter() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("a");
	Iterator<String> it = new UniqueFilterIterator(list.iterator());
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("自定义过滤器");
		list.add("refer");
		list.add("dad");
		list.add("sssss");
		list.add("moom");
		list.add("xls");
		//自定义条件判断
		Predicate<String> pre = new Predicate<String>() {

			@Override
			public boolean evaluate(String value) {
				// TODO Auto-generated method stub
				//回文判断
				return new StringBuilder(value).reverse().toString().equals(value);
			}
			
		};
		//过滤器
		Iterator<String> it22= new FilterIterator(list.iterator(),pre);
		while(it22.hasNext()) {
			System.out.println(it22.next());
		}
		
		/**
		 * 循环迭代器
		 */
		System.out.println("循环迭代器");
		Iterator<String> it21 = new LoopingIterator(list);
		for(int i = 0; i < 15; i++) {
			System.out.println(it21.next());
		}
		System.out.println("数组迭代器");
		int[] str = {1,2,3,4,5};
		
		Iterator<Integer> it222= new ArrayListIterator<Integer>(str);
		while(it222.hasNext()) {
			System.out.println(it222.next());
		}
	}
	
	/**
	 * 	Map迭代器
	 */
	public static void TestIterator() {
	IterableMap<String,String> map = new HashedMap<String,String>();
	map.put("a", "bjsxt");
	map.put("b", "s");
	map.put("c", "aa");
	//map.entrySet()  -- map.keyset() 取key，
//	map.entrySet().iterator()
//	map.keySet().iterator()
	System.out.println("-----keyset-----");
	Iterator<String> it2 = map.keySet().iterator();
	while(it2.hasNext()) {
		
		String key = it2.next();
		String value = map.get(key);
		System.out.println(key + "," + value);
	}
	
	System.out.println("-----entrySet-----");
	Iterator<Entry<String, String>> it3 = map.entrySet().iterator();
	while(it3.hasNext()) {
		String key = it3.next().getKey();
		String value = map.get(key);
		System.out.println(key + "," + value);
	}
	//只需要使用
	System.out.println("-----MapIterator-----");
	MapIterator<String,String> it = map.mapIterator();
	while(it.hasNext()) {
		String key = it.next();
		String value = it.getValue();
		System.out.println(key + "," + value);
	}
	it = map.mapIterator();
	while(it.hasNext()) {
		it.next();
		String key = it.getKey();
		String value = it.getValue();
		System.out.println(key + "," + value);
	}
	}
	/**
	 * 队列
	 */
	
	public static void TestQue() {
		/**
		 * 队列
		 */
		CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		
		for(String str : que) {
			System.out.println(str);
		}
		
		/**
		 * 只读队列
		 */

		Queue<String> readOnlyQue = UnmodifiableQueue.unmodifiableQueue(que);
		//报错，只读队列
		//readOnlyQue.add("d");
		/**
		 * 断言
		 */
		
		Predicate notNull=NotNullPredicate.INSTANCE;
		Queue<String> que2 = PredicatedQueue.predicatedQueue(que, notNull);
		
		//断言 出错que2.add(null);
		
	}
	
	/**
	 * 集合操作
	 * 
	 */
	
	public static void SetFunc() {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(2);
		set1.add(3);
		set1.add(4);
		
		//并集
		Collection<Integer> col = CollectionUtils.union(set, set1);
		for(Integer tmp:col) {
			System.out.print(tmp);
		}
		System.out.println();
		//交集
		//Collection<Integer> col1 = CollectionUtils.intersection(set, set1);
		Collection<Integer> col1 = CollectionUtils.retainAll(set, set1);
		for(Integer tmp:col1) {
			System.out.print(tmp);
		}
		System.out.println();
		//差集
		Collection<Integer> col2 = CollectionUtils.subtract(set, set1);
		for(Integer tmp:col2) {
			System.out.print(tmp);
		}
		System.out.println();
	}
	/**
	 * 如果是打折商品，进行九折，否则满一百减二十
	 */
	public static void ifClosure() {
		List<Goods> list = new ArrayList<Goods>();
		list.add(new Goods("java", 123,true));
		list.add(new Goods("javsa", 11,true));
		list.add(new Goods("javaaa", 23,false));
		
		
		//业务逻辑
		//2.选一
		Closure<Goods> subtract = new Closure<Goods>() {

			@Override
			public void execute(Goods good) {
				// TODO Auto-generated method stub
				if(good.getPrice() >= 100)
					good.setPrice(good.getPrice() - 20);
			}
			
		};
		Closure<Goods> discount = new Closure<Goods>() {

			@Override
			public void execute(Goods good) {
				// TODO Auto-generated method stub
				if(good.isDiscount())
					good.setPrice(good.getPrice()*0.9);
			}
			
		};
		
		Predicate<Goods> pre = new Predicate<Goods>() {

			@Override
			public boolean evaluate(Goods good) {
				// TODO Auto-generated method stub
				return good.isDiscount();
			}
			
		};
		
		Closure<Goods> ifClo = IfClosure.ifClosure(pre, discount,subtract);
		CollectionUtils.forAllDo(list, ifClo);
		
		for(Goods tmp : list) {
			System.out.println(tmp);
		}
		
	}
	
	/**
	 * 确保所有的员工工资都大于1万，已经超过的不再上涨
	 * 
	 */
	public static void updateSalary() {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("sjsj",1010101010));
		list.add(new Employee("jsj",10));
		
		//所有员工工资上涨
		//业务功能
		Closure<Employee> cols = new Closure<Employee>() {

			@Override
			public void execute(Employee em) {
				// TODO Auto-generated method stub
				em.setSalary(em.getSalary() * 1.2);
			}
			
		};
		
		Predicate<Employee> empPre = new Predicate<Employee>() {

			@Override
			public boolean evaluate(Employee emp) {
				// TODO Auto-generated method stub
				return emp.getSalary() > 10000;
			}
			
		};
		//false 表示while先判断后执行
		//true 表示先执行后判断
		Closure<Employee> whileCols = WhileClosure.whileClosure(empPre, cols, false);
		//结合数据
		CollectionUtils.forAllDo(list, cols);
		
		//操作后数据
		Iterator<Employee> empIt = list.iterator();
		while(empIt.hasNext()){
			System.out.println(empIt.next());
		}
	}
	
	public static void SelfTrans(String[] args) {
		System.out.println("自定义类型转换");
		//1. 判别式
		Predicate<Employee> isLow = new Predicate<Employee>() {
			
			@Override
			public boolean evaluate(Employee emp) {
				// TODO Auto-generated method stub
				return emp.getSalary()<=1000;
			}
			
		};
		
		Predicate<Employee> isHigh = new Predicate<Employee>() {
			
			@Override
			public boolean evaluate(Employee emp) {
				// TODO Auto-generated method stub
				return emp.getSalary()>=10000;
			}
			
		};
		
		Predicate[] pre = {isLow,isHigh};
		
		//转换
		Transformer<Employee, Level> LowTrans = new Transformer<Employee,Level>(){
			
			@Override
			public Level transform(Employee input) {
				// TODO Auto-generated method stub
				return new Level(input.getName(),"卖身");
			}
		};
		
		Transformer<Employee, Level> HighTrans = new Transformer<Employee,Level>(){
			
			@Override
			public Level transform(Employee input) {
				// TODO Auto-generated method stub
				return new Level(input.getName(),"养身");
			}
		};
		
		
		Transformer[] trans	= {LowTrans, HighTrans};
		//用一个开关进行关联
		Transformer switchTrans = new SwitchTransformer(pre,trans,null);
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("sjsj",1010101010));
		list.add(new Employee("jsj",10));
		
		
		//进行转换
		Collection<Level> levelList = CollectionUtils.collect(list,switchTrans);
		
		//遍历容器
		Iterator<Level> leveIt = levelList.iterator();
		while(leveIt.hasNext()) {
			System.out.println(leveIt.next());
		}
	}
	
	public static void innerTransformer() {
		//重写transform 方法
		System.out.println("内置类型转换 长整型日期时间， 转换成指定格式的字符串");
		//不需要遍历容器，写好类型转换器就行
		Transformer<Long,String> trans = new Transformer<Long,String>(){

			@Override
			public String transform(Long input) {
				// TODO Auto-generated method stub
				return new SimpleDateFormat("yyyy年mm月dd日").format(input);
			}
			
		};
		
		List<Long> list = new ArrayList<Long>();
		list.add(9999999999L);
		list.add(29292929292L);
		//指定元素转换
		//工具类
		Collection<String> result = CollectionUtils.collect(list, trans);
		for(String st : result) {
			System.out.println(st);
		}
		
	}
	
	public static void selfAllPre() {
		System.out.println("======自定义判断========");
		Predicate<String> selPre = new Predicate<String>() {

			@Override
			public boolean evaluate(String arg0) {
				// TODO Auto-generated method stub
				return arg0.length() >= 5 && arg0.length() <=20;
				
			}
			
		};
		Predicate<String> uniquPre = UniquePredicate.uniquePredicate();
		
		//组合
		Predicate all = PredicateUtils.andPredicate(uniquPre,selPre);
		List<String> list = PredicatedList.predicatedList(new ArrayList<String>(), all);
		list.add("ccdddc");
	}
	
	public static void unique() {
		System.out.println("======唯一性判断========");
		
		Predicate<Long> uniquPre = UniquePredicate.uniquePredicate();
		List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), uniquPre);
		list.add(100L);
		list.add(200L);
		//出现重复值抛出异常
		list.add(100L);
	}
	
	public static void notNull() {
		
			System.out.println("======非空判断========");
			//Predicate notNull = NotNullPredicate.INSTANCE;
			Predicate notNull = NotNullPredicate.notNullPredicate();
			String str = "kksks";
			System.out.println(notNull.evaluate(str));
			
			//添加容器时判断
			PredicatedList<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), notNull);
			list.add(1000L);
			//验证失败出现异常
			
			list.add(null);
		}
	public static void equals() {
		System.out.println("======相等判断========");
		Predicate<String> pre = new EqualPredicate<String>("jay");
		boolean flag = pre.equals("ss");
		System.out.println(flag);
	}
}
