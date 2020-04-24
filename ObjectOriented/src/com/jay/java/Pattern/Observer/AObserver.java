package com.jay.java.Pattern.Observer;

public class AObserver implements Observer{
	private int myState;//myState需要跟目标对象保持一致

	@Override
	public void update(Subject subject) {
		myState = ((ConcreteSubject)subject).getState();
	}

	public int getMyState() {
		return myState;
	}

	public void setMyState(int myState) {
		this.myState = myState;
	}
	
	
}
