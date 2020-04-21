package com.jay.java.Pattern.Factory.AbstractFactory;

public interface CarFactory {
	Engine createEngine();
	Seat createSeat();
	Tyre createTyre();
}


