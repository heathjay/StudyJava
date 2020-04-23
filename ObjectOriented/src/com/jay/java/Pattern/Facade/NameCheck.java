package com.jay.java.Pattern.Facade;

public interface NameCheck {
	public void checkName();
}
class MyNameCheck implements NameCheck{

	@Override
	public void checkName() {
		System.out.println("NameCheck");
	}
	
}
