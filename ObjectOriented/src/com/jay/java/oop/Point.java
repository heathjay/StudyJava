package com.jay.java.oop;
/**
 * 构造方法练习
 * @author jay
 *
 */
public class Point {
	private double x, y, z;
	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	public void setZ(double z) {
		this.z = z;
	}
	
	public double getDistance(Point p1) {
		return Math.sqrt((this.x-p1.x) * (this.x-p1.x) + (this.y-p1.y) * (this.y-p1.y) + (this.z-p1.z) * (this.z-p1.z));
	}
	public static void main(String[] args) {
		Point p = new Point(1,2,3);
		Point p1 = new Point(1,2,0);
		
		System.out.println("x:" + p.x + "y:" + p.y +" z:" + p.z);
		System.out.println(p.getDistance(p1));
	}
}
