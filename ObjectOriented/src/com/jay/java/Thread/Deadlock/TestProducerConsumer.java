package com.jay.java.Thread.Deadlock;
/**
 * 生产者，消费者模式
 * 解决死锁问题的一个方案:
 * 1. 生产者生产一定的数据放在缓存区域，
 * 2. 消费者消费数据
 * 3. 保证生产者不会在缓冲区满的时候加入数据，
 * 4.消费者也不会在缓冲区空的时候消耗数据
 * 
 * - 要求
 * --- 生产者在缓冲区满的时候进行休眠，然后等到下一次消费者消耗缓冲区资源的时候唤醒
 * --- 消费者在缓冲区空的时候进行休眠，等到生产者是放入的时候开始唤醒
 * 
 * - 通常由信号灯，管道
 * - wait() -> 释放锁
 * - notify()
 * - 两个方法需要用同步一起使用synchronized
 * 
 * --- 管程方法
 * 
 * @author jay
 *
 */
public class TestProducerConsumer {
	public static void main(String[] args) {
		//共同的资源
		Moive m = new Moive();
		
		Player p = new Player(m);
		Watcher w = new Watcher(m);
		
		new Thread(p).start();
		new Thread(w).start();
	}
}
class Player implements Runnable{
	//相当于生产者
	private Moive m;

	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			if(0 == i % 2) {
				m.play("jsjsis");
			}else {
				m.play("xxxxx");
			}
		}
	}

	public Player(Moive m) {
		super();
		this.m = m;
	}
	
}

class Watcher implements Runnable{
	private Moive m;

	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			m.watch();
		}
	}

	public Watcher(Moive m) {
		super();
		this.m = m;
	}
	
	
}

class Moive{
	private String pic;
	private boolean flag = true;
	//信号灯
	//flag - > T 生产者生产，消费者等待, wait()
	// flag -  > false  消费，生产者等待,notify()
	
	public synchronized void play(String pic) {
		
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//开始生产
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.pic = pic;
		//通知消费
		this.notify();
		this.flag  = false;
	}
	public synchronized void watch() {
		
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//开始消费
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(pic);
		//通知
		this.notify();
		this.flag = true;
	}
}
