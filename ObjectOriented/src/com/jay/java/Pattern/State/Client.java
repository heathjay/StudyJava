package com.jay.java.Pattern.State;

public class Client {
	public static void main(String[] args) {
		Context ctx = new Context();
		
		
		ctx.setState(new FreeState());
	}
}
