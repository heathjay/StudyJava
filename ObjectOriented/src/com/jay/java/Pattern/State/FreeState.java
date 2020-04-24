package com.jay.java.Pattern.State;
/**
 * 空闲状态
 * @author jay
 *
 */
public class FreeState implements State{

	@Override
	public void handle() {
		System.out.println("free state");
	}

}
