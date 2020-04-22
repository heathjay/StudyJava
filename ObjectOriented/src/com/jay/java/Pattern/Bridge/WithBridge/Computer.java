package com.jay.java.Pattern.Bridge.WithBridge;
/**
 * 电脑类型的维度
 * @author jay
 *
 */
public abstract class Computer {
	protected Brand brand;

	public Computer(Brand brand) {
		super();
		this.brand = brand;
	}
	
	
	public void sale() {
		brand.sale();
	}
}

class Destop extends Computer{
	public Destop(Brand brand) {
		super(brand);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		super.sale();
		System.out.println("销售台式机");
	}
}

class Laptop extends Computer{
	public Laptop(Brand brand) {
		super(brand);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		super.sale();
		System.out.println("销售笔记本");
	}
}
