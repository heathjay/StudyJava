package com.jay.java.Pattern.Factory.AbstractFactory;

public interface Engine {
	void run();
	void start();
}

class LuxuryEngine implements Engine{

	@Override
	public void run() {
		System.out.println("快");
	}

	@Override
	public void start() {
		System.out.println("启动快");
		
	}
	
}
class LowEngine implements Engine{

	@Override
	public void run() {
		System.out.println("慢");
	}

	@Override
	public void start() {
		System.out.println("启动慢");
		
	}
	
}