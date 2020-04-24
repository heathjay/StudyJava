package com.jay.java.Pattern.State;

public class CheckedInState implements State{

	@Override
	public void handle() {
		System.out.println("CheckedInState");
	}
	
}
