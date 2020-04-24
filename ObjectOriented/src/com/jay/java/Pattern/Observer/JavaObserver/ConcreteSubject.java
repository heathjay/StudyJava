package com.jay.java.Pattern.Observer.JavaObserver;

import java.util.Observable;
/**
 * 目标对象
 * @author jay
 *
 */
public class ConcreteSubject extends Observable{
	private int state;

	public void setState(int state) {
		this.state = state;
		
		/**
		 * Observable里面的方法，表示目标对象已经做了修改
		 */
		this.setChanged();
		/**
		 * Observable里面的方法，对观察者做修改
		 */
		this.notifyObservers();
	}

	public int getState() {
		return state;
	}
	
	
}
