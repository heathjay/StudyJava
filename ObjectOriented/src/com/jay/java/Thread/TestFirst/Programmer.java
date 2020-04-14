package com.jay.java.Thread.TestFirst;
/**
 * 2.实现runnable接口实现Thread的生成
 * @author jay
 *
 */
public class Programmer implements Runnable{

	@Override
	public void run() {
		for(int i =0;i<20;i++) {
			System.out.println("jiajija");
		}
	}

}
