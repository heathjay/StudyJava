package com.jay.java.MyProject01;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jay.java.MyProject01.GameFrame.PaintThread;

/**
 * 测试窗口物体沿着各种轨迹移动
 * @author jay
 * 6.任意角度飞，弧度
 * 		- degree
 * 7.弹起来
 * 		- 分析各个边
 * 		- 两边 pai - degree
 * 		- 下面 
 * 8. 让球停下来
 * 		- speed = 0
 * 9. 共同代码，写一个父类，直接进行继承使用，
 */
public class GameFrame2 extends Frame{
	Image img = GameUtil.getImage("images/oval.jpg");
	
	//1.打开窗口	
	public void launchFrame() {
		//位置，
		this.setSize(500,500);
		this.setLocation(100,100);
		//默认不可见
		this.setVisible(true);
		
		
		new PaintThread().start();
		this.addWindowListener(new WindowAdapter() {

			/* (non-Javadoc)
			 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//结束，正常退出传入0
				System.exit(0);
			}
			
		});
		
		
	}
	
	
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
	/*
	 * 重画线程类
	 * 内部类，方便调用外部类方法
	 */
	
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		GameFrame2 gf = new GameFrame2();
		gf.launchFrame();
	
	}

}
