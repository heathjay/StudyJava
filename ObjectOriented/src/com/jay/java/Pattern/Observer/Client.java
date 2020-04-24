package com.jay.java.Pattern.Observer;

public class Client {
	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();
		
		AObserver obs1 = new AObserver();
		AObserver obs2 = new AObserver();
		AObserver obs3 = new AObserver();

		subject.register(obs1);
		subject.register(obs2);
		subject.register(obs3);
		
		subject.setState(3000);
		
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
	}
}
