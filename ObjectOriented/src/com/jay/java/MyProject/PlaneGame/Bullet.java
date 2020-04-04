package com.jay.java.MyProject.PlaneGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * @author jay
 * 4.1 
 */
public class Bullet extends GameObject{
	/*6.1
	double x,y;
	int speed = 3 ;
	int height = 10;
	int width = 10;
	public Rectangle getRect() {
		return new Rectangle((int)x,(int)y, width,height);
		
	}
	*/
	double degree;
	public Bullet() {
		degree = Math.random() *Math.PI * 2;
		this.x = Constant.GAME_WIDTH / 2;
		this.y = Constant.GAME_HEIGHT / 2;
		this.width = 10;
		this.height = 10;
	}
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int)x, (int)y, width, height);
		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);
		
		if(y > Constant.GAME_HEIGHT - this.height / 2 || y <this.height / 2) {
			this.degree = -degree;
		}
		if(x > Constant.GAME_WIDTH - this.width / 2 || x < this.width / 2) {
			this.degree = Math.PI - degree;
		}
		
		g.setColor(c);
	}
}
