package com.jay.java.Pattern.Strategy;

public class Client {
	public static void main(String[] args) {
		
		Strategy s1 = new OldCustomerManyStrategy();
		
		Context ctx = new Context(s1);
		
		ctx.pringPrice(999);
	}
}
