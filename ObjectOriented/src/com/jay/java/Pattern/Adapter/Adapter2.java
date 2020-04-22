package com.jay.java.Pattern.Adapter;
/**
 * 组合适配器，对象适配器，使用了组合的方式跟被适配对象进行组合
 * @author jay
 *
 */
public class Adapter2 implements Target{
	private Adaptee adaptee;
	@Override
	public void handleReq() {
		adaptee.request();
	}
	public Adapter2(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}
	
}