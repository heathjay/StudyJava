package com.jay.java.Pattern.Decorator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Client {
	public static void main(String[] args) throws FileNotFoundException {
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
		//FileInputStream真实角色
		Reader r = new BufferedReader(new InputStreamReader(new FileInputStream(new File("a.txt"))));
	}
}
