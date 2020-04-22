package com.jay.java.Pattern.Decorator;

public class Client {
	public static void main(String[] args) {
		//具体的车
		Car car = new Car();
		car.move();
		
		//增加飞行的功能
		System.out.println("增加飞行----");
		FlyCar flyCar = new FlyCar(car);
		flyCar.move();
		
		System.out.println("新增加的功能，水里游----");
		WaterCar waterCar = new WaterCar(car);
		waterCar.move();

		//Car - FlyCar
		System.out.println("复合----");
		WaterCar waterCar1 = new WaterCar(flyCar);
		waterCar1.move();
	}
}
