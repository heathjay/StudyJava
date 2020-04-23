package com.jay.java.Pattern.Facade;
/**
 * 
 * @author jay
 *
 */
public interface BankCheck {
	public void checkBank();
}

class MyBankCheck implements BankCheck{

	@Override
	public void checkBank() {
		System.out.println("BankCheck");
	}
	
}
