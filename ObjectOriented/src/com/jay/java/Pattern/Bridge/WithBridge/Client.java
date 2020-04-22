package com.jay.java.Pattern.Bridge.WithBridge;

public class Client {
	public static void main(String[] args) {
		//销售联想笔记本
		Computer cl = new Laptop(new Lenovo());
		cl.sale();
	}
}
