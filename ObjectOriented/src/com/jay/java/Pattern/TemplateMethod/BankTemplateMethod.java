package com.jay.java.Pattern.TemplateMethod;

public abstract class BankTemplateMethod {
	//具体方法
	public void takeNumber() {
		System.out.println("取号");
	}
	
	public abstract void transact();
	
	public void evaluate() {
		System.out.println("反馈评分");
	}
	
	public final void process() {
		//模版方法
		this.takeNumber();
		this.transact();
		this.evaluate();
	}
}
