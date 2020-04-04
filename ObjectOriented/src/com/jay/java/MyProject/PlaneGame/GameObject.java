package com.jay.java.MyProject.PlaneGame;

import java.awt.Image;
import java.awt.Rectangle;

/**
 * 封装
 * @author jay
 *
 */
public class GameObject {
	double x,y;
	int speed = 3 ;
	int height = 10;
	int width = 10;
	Image img;
	public Rectangle getRect() {
		return new Rectangle((int)x,(int)y, width,height);
		
	}
	public GameObject(double x, double y, int speed, int height, int width, Image img) {
		super();
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.height = height;
		this.width = width;
		this.img = img;
	}
	public GameObject() {
		
	}
}
