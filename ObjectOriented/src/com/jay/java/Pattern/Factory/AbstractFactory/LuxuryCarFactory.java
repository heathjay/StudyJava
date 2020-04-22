package com.jay.java.Pattern.Factory.AbstractFactory;

//import com.jay.java.Pattern.Factory.AbstractFactory.Engine;

public class LuxuryCarFactory implements CarFactory{

	@Override
	public Engine createEngine() {
		return new LuxuryEngine();
		
	}

	@Override
	public Seat createSeat() {
		return new LuxurySeat();
	}

	@Override
	public Tyre createTyre() {
		return new LuxuryTyre();
	}
	
}