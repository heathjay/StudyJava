package com.jay.java.Pattern.Adapter;
/**
 * 适配器本身,类适配器方式
 * 关联被适配对象：
 * - 继承
 * 	问题：单继承不够灵活
 * @author jay
 *
 */
public class Adapter extends Adaptee implements Target{

	@Override
	public void handleReq() {
		super.request();
	}
	
}
