package com.jay.java.MyProject.PlaneGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 * 2，飞机类
 * 	-属性
 * 		- 位置，x,y
 * 		- 图片
 * 	- 方法
 * 		- draw
 * 	- 构造器
 * @author jay
 *
 */
public class Plane extends GameObject{
	/*6.1
	Image img = GameUtil.getImage("images/plane1.png");
	int speed = 10;
	double x,y;
	*/
	boolean left, up, right, down;
	//7.1life
	private boolean live = true;
	
	
	/**
	 * @return the live
	 */
	public boolean isLive() {
		return live;
	}

	/**
	 * @param live the live to set
	 */
	public void setLive(boolean live) {
		this.live = live;
	}

	public void draw(Graphics g) {
		if(live) {
			g.drawImage(img,(int)this.x,(int)this.y,null);
			move();
		}
	}
	
	/*
	 * move 1.0 根据keyEvent变化捕获而变化
	 */
	/*
	public void move(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 37:
			this.x -= 10;
			break;
		case 38:
			this.y -= 10;
			break;
		case 39:
			this.x += 10;
			break;
		case  40:
			this.y += 10;
			break;
		default:
				break;
		}
	}
	*/
	/*6.1
	int width,height;
	public Rectangle getRect() {
		return new Rectangle((int)x,(int)y, width,height);
		
	}
	*/
	public void move() {
		if(left) {
			this.x -= speed;
		}
		if(right) {
			this.x += speed;
		}
		if(up) {
			this.y -= speed;
		}
		if(down) {
			this.y += speed;
		}
	}
	
	public void addDirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			this.left = true;
			break;
		case KeyEvent.VK_RIGHT:
			this.right = true;
			break;
		case KeyEvent.VK_DOWN:
			this.down = true;
			break;
		case  KeyEvent.VK_UP:
			this.up = true;
			break;
		default:
				break;
		}
	}
	
	public void delDirection(KeyEvent e) {
		System.out.println("释放" + e.getKeyCode());
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case  KeyEvent.VK_UP:
			up = false;
			break;
		default:
				break;
		}
	}
	public Plane(String ImagePath, double x, double y) {
		super();
		this.img = GameUtil.getImage(ImagePath);
		this.x = x;
		this.y = y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	public Plane() {
		
	}
}
