package com.jay.java.Pattern.Factory.FactoryMethod;

public class BydFactory implements CarFactory{
	@Override
	public Car createCar() {
		return new Byd();
	}

}
