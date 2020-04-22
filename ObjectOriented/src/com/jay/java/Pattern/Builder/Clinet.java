package com.jay.java.Pattern.Builder;

public class Clinet {
	public static void main(String[] args) {
		Director director = new MyDirector(new MyBuilder());
		
		AirShip ship = director.directorAirShip();
		ship.launch();
	}
}
