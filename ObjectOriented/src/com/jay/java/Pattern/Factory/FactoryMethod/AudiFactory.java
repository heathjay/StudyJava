package com.jay.java.Pattern.Factory.FactoryMethod;

public class AudiFactory implements CarFactory{
	@Override
	public Car createCar() {
		return new Audi();
	}

}
