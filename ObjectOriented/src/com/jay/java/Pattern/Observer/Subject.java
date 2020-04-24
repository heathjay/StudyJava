package com.jay.java.Pattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	protected List<Observer> list = new ArrayList<Observer>();
	
	public void register(Observer obs) {
		list.add(obs);
	}
	
	public void removeObserver(Observer obs) {
		list.remove(obs);
	}
	
	public void notifyAllObservers() {
		for(Observer obs : list) {
			obs.update(this);
		}
	}
}
