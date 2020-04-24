package com.jay.java.Pattern.Observer;

public class ConcreteSubject extends Subject{
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		/**
		 * 目标对象值发送变化，通知所有观察对象
		 */
		this.notifyAllObservers();
	}
	
	

}
