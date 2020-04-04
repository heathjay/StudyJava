package com.jay.java.MyProjectSun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 * 行星
 * @author jay
 *
 */
public class Planet extends Star{
	//行星区别：
	//图片，椭圆轨迹，长轴短轴、速度
	double longAxis;
	double shortAxis;
	double speed;
	double degree;
	Star center;
	
	
	
	public Planet(String imgPath, double longAxis, double shortAxis, double speed, Star center) {
		super(GameUtil.getImage(imgPath));
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.center = center;
		this.x = center.x + this.longAxis;
		this.y = center.y;
	
	}
	public Planet(Image img, double x,double y) {
		super(img,x,y);
	}
	public Planet(String imgPath, double x,double y) {
		super(imgPath,x,y);
	}
	/* (non-Javadoc)
	 * @see com.jay.java.MyProjectSun.Star#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		super.draw(g);
		this.drawTrace(g);
		this.move();
	}
	public void move() {
		//沿着椭圆轨迹飞行
		x = this.center.x + center.width / 2 + this.longAxis * Math.cos(degree) - this.width/2;
		y = this.center.y + center.height / 2 + this.shortAxis * Math.sin(degree) - this.height/2;
		degree += speed;
	}
	public void drawTrace(Graphics g) {
		double _x,_y,_width,_height;
		
		_width = this.longAxis*2;
		_height = this.shortAxis * 2;
		_x = center.x + center.width / 2- this.longAxis;
		_y = center.y + center.height / 2 - this.shortAxis;
		
		Color c =g.getColor();
		g.setColor(Color.RED);
		g.drawOval((int)_x, (int)_y,(int)_width,(int)_height);
		g.setColor(c);
	}
	
}
