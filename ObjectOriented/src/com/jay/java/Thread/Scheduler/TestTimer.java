package com.jay.java.Thread.Scheduler;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 程序调度
 * - xx事件后进行调度
 * - 定时器Timer
 * -Timer()
 * - scheduale(TimerTask task, Date firstTime, long period)
 * @author jay
 *
 */
public class TestTimer {
	public static void main(String[] args) {
		Timer t = new Timer();
		
		//线程任务实例
		//开始时间
		//每隔多少时间
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("sssisisu");
			}
			
			
		}, new Date(System.currentTimeMillis()+ 1000), 200);
	}
}
