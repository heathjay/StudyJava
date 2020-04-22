package com.jay.java.Pattern.Decorator;
/**
 * 装饰模式
 * @author jay
 *
 */
public interface ICar {
	void move();
}

//真实构建,ConcreteComponent 
class Car implements ICar{

	@Override
	public void move() {
		System.out.println("陆地上跑");
	}
}

class SuperCar implements ICar{
	protected ICar car;
	
	public SuperCar(ICar car) {
		super();
		this.car = car;
	}

	@Override
	public void move() {
		car.move();
	}
	
}
/**
 * 具体装饰对象
 * ConcreteDecorator
 * @author jay
 *
 */
class FlyCar extends SuperCar{

	public FlyCar(ICar car) {
		super(car);
	}

	@Override
	public void move() {
		super.move();
		fly();
	}
	public void fly() {
		System.out.println("天上飞!");
	}
	
}

class WaterCar extends SuperCar{

	public WaterCar(ICar car) {
		super(car);
	}

	@Override
	public void move() {
		super.move();
		swim();
	}
	public void swim() {
		System.out.println("游泳!");
	}
	
}