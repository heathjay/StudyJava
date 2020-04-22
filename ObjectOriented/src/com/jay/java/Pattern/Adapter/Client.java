package com.jay.java.Pattern.Adapter;
/**
 * 客户端进行检测
 * @author jay
 *
 */
public class Client {
	public void test1(Target t) {
		t.handleReq();
	}
	
	public static void main(String[] args) {
		Client c = new Client();
		Adaptee a = new Adaptee();
		Target t = new Adapter();
		c.test1(t);
		
		Target t2 = new Adapter2(a);
		c.test1(t2);
	}
}
