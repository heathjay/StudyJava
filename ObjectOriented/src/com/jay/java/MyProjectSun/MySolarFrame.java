package com.jay.java.MyProjectSun;

import java.awt.Graphics;
import java.awt.Image;

/**
 * 太阳系主窗口
 * @author jay
 *
 */
public class MySolarFrame extends MyFrame {


	Image bg = GameUtil.getImage("images/bg.jpg");
	Star sun = new Star("images/sun1.png",Constant.GAME_WIDTH / 2,Constant.GAME_HEIGHT / 2);
	Planet earth = new Planet("images/sun2.png", 150, 100, 0.1, sun);
	Planet Mars = new Planet("images/sun3.png",200,130,0.2,sun);
	Planet Moon = new Planet("images/sun7.png",30,20,0.3,earth);
	/* (non-Javadoc)
	 * @see java.awt.Window#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(bg, 0, 0,null);
		sun.draw(g);
		earth.draw(g);
		Mars.draw(g);
	}
	
	public static void main(String[] args) {
		new MySolarFrame().launchFrame();
	}
	
}
