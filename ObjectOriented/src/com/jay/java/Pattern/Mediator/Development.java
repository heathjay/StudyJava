package com.jay.java.Pattern.Mediator;

public class Development implements Department{
	private Mediator m;

	@Override
	public void selfAction() {
		System.out.println("lack for money");
	}

	public Development(Mediator m) {
		super();
		this.m = m;
		m.register("development", this);//互相持有引用
	}

	@Override
	public void outAction() {
		System.out.println("Development works");
		
	}
	
	
}
