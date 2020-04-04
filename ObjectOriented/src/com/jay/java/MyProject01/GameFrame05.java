package com.jay.java.MyProject01;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jay.java.MyProject01.GameFrame.PaintThread;

/**
 * 继承父类,实现更好的结构，只用hook改动就行
 * @author jay
 *
 */
public class GameFrame05 extends MyFrame{
	//3.加载图片
		Image img = GameUtil.getImage("images/oval.jpg");
		
		private double x=100,y=100;
		private boolean left, up;
		private double degree = 3.14 / 3;
		private double speed = 10;
		
		//2.窗口上面画东西
		
		/* (non-Javadoc)
		 * @see java.awt.Window#paint(java.awt.Graphics)
		 */
		@Override
		public void paint(Graphics g) {
				
			g.drawImage(img,(int) x, (int)y, null);
			x += speed * Math.cos(degree);
			y += speed* Math.sin(degree);
			
			if(speed > 0) {
				speed -= 0.05;
			}else {
				speed = 0;
			}
			if( y > 500 - 30) {
				degree = -degree;
			}
			if(y < 30) {
				degree = -degree;
			}
			if(x < 0 || x > 500 -30) {
				degree = Math.PI - degree;
			}
			
			
		}

		public static void main(String[] args) {
			GameFrame05 gf = new GameFrame05();
			gf.launchFrame();
		
		}
}
