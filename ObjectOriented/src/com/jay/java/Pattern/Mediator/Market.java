package com.jay.java.Pattern.Mediator;

public class Market implements Department{
	private Mediator m;

	@Override
	public void selfAction() {
		System.out.println("uses money");
	}

	public Market(Mediator m) {
		super();
		this.m = m;
		m.register("market", this);//互相持有引用
	}

	@Override
	public void outAction() {
		System.out.println("market works");
		m.command("finacial");
	}
	
	
}
