package com.jay.java.MyProjectSun;

import java.awt.Graphics;
import java.awt.Image;

/**
 * 星星类父类
 * @author jay
 *
 */
public class Star {
	Image img;
	double x, y;
	int width,height;
	
	
	public void draw(Graphics g) {
		g.drawImage(img, (int)x,(int)y,null);
	}
	
	public Star(Image img, double x, double y) {
		this(img);
		this.x = x;
		this.y = y;
	}
	public Star(String imagpath, double x, double y) {
		this(GameUtil.getImage(imagpath),x,y);
	}
	public Star() {
		
	}
	
	public Star(Image img) {
		this.img = img;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
}
