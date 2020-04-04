package com.jay.java.MyProject01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * windows
 * @author jay
 *	GUI: awt, swing等
 *		awt比较落后，swing也用不着，java不擅长用来写桌面软件
 *
 *	window:
 *		位置，高度和宽度
 *		以一个点的坐标来固定矩形的位置，左上角的点为坐标
 *		碰到与否，比如爆炸的矩形和原来的矩形是否相交叉，
 *	1. 启动窗口，位置，大小
 *	2. 关闭，增加一个监听，里面一个匿名内部类，重写窗口关闭的方法,调用System.exit(0)
 *	3. 窗口里面画东西, 重写父类方法，paint（Graphic g）g为画笔，
 *		- g.drawLine(x,y)
 *		- g.drawOval(x,y,w,h)
 *		- g.drawRect(x,y,w,h)
 *		- g.drawString(str,x,y)
 *		- g.fillRect(x,y,w,h)
 *		- g.fillOval(x,y,w,h)
 *System.out.println("paint");
		// TODO Auto-generated method stub
		// g是一个画笔，可以随意画东西，
		g.drawLine(100, 100, 200, 200);
		g.drawRect(100, 100, 200, 200);
		//矩形的内切
		g.drawOval(100, 100, 200, 200);
		//字体设定
		Font f = new Font("宋体",Font.BOLD,100);
		g.setFont(f);
		//字符串
		g.drawString("jay", 200, 200);
		
		Color c = g.getColor();
		g.setColor(new Color(255,0,0));
		g.fillRect(200, 200, 10, 10);
		g.fillOval(300, 300, 20, 20);
			g.setColor(c);
 *	4.图片加载：
 *		- GameUtil工具类中提供getImage方法, 
 *			- 方法都是static方法
 *			- 构造方法私有
 *			- 外部只用调用static方法
 *		- 在GameFrame类中作为成员变量，然后在paint中使用g.drawImage(img,x,y.null)
 *	5.让图片动起来，
 *		- 内部类：继承线程，线程中重写run函数，函数里面的调用外部类的方法repaint()
 *		- 启动函数里,launch（）new一个新的线程对象，
 *		- paint函数里面，drawImg里面的坐标可以改变
 *
 */
public class GameFrame extends Frame{
	//3.加载图片
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
	//2.窗口上面画东西
	
	/* (non-Javadoc)
	 * @see java.awt.Window#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
			
		g.drawImage(img,(int) x, (int)y, null);
		x+=3;
		//公用一支笔，换成自己的颜色，然后返回你set回
		
		
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
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	
	}
}
