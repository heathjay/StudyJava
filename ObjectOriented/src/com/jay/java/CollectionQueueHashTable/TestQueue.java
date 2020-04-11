package com.jay.java.CollectionQueueHashTable;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * queue
 * 	- 单向
 * 	- FIFO
 * 	- 增删改查
 * deque
 * 	- 两端访问
 * 	- addFirst/ addLast
 * 	
 * 模拟业务
 * 
 * - 利用队列进行自定义堆栈
 * - 弹
 * - 压
 * - 获取头
 * @author jay
 *
 */

interface Request{
	//存款
	void deposit();
}

class MyStack<E>{
	private Deque<E> container = new ArrayDeque<E>();
	private int cap;
	public MyStack(int cap) {
		super();
		this.cap = cap;
	}
	
	//压栈
	public boolean push(E e) {
		if(container.size() + 1 > cap) {
			return false;
		}
		return container.offerLast(e);
	}
	
	//弹出来
	public E pop() {
		return container.pollLast();

	}
	//
	public E peek() {
		return container.peekLast();
	}
	
	public int size() {
		return this.container.size();
	}
	
}
public class TestQueue {
	public static void main(String args[]) {
		//TestQueue.TestQueueF();
		TestMyStack();
	}
	

	public static void TestMyStack() {
		MyStack<String> bh = new MyStack<String>(3);
		bh.push("www.baidu.com");
		bh.push("www.a.com");
		bh.push("www.s.com");
		bh.push("www.d.com");
		bh.push("www.q.com");
		System.out.println(bh.size());
		
		String str = null;
		while(null != (str = bh.pop())) {
			System.out.println(str);
		}
	}
	
	public static void TestQueueF() {
		Queue<Request> que = new ArrayDeque<Request>();
		//模拟排队情况
		for(int i = 0; i < 10;i++) {
			final int num = i;
			que.offer(new Request() {

				@Override
				public void deposit() {
					System.out.println("No."+ num +" "+ Math.random()*10000);	
				}
			});
		}
		dealWith(que);
	}
	public static void dealWith(Queue<Request> que) {
		Request req = null;
		while(null != (req = que.poll())) {
			req.deposit();
		}
	}
}
