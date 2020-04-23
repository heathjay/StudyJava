package com.jay.java.Pattern.FlyWeight;
/**
 * 享元类
 * @author jay
 *
 */
public interface ChessFlyWeight {
	void setColor(String color);
	String getColor();
	void display(Coordinate c);
}

class ConcreteChess implements ChessFlyWeight{
		private String color;

		@Override
		public void setColor(String color) {
			// TODO Auto-generated method stub
			this.color = color;
		}

		@Override
		public String getColor() {
			// TODO Auto-generated method stub
			return this.color;
		}

		@Override
		public void display(Coordinate c) {
			System.out.println("color:" + this.color +"x,y"+c.getX()+","+c.getY());
		}

		public ConcreteChess(String color) {
			super();
			this.color = color;
		}
		
		
}
