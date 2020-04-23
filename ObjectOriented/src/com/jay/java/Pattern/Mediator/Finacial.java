package com.jay.java.Pattern.Mediator;

public class Finacial implements Department{
	private Mediator m;

	@Override
	public void selfAction() {
		System.out.println("lots of money");
	}

	public Finacial(Mediator m) {
		super();
		this.m = m;
		m.register("finacial", this);//互相持有引用
	}

	@Override
	public void outAction() {
		System.out.println("finacial works");
		
	}
	
	
}
