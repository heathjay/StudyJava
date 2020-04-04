package com.jay.java.MyProject.PlaneGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

/**
 * 窗口
 * @author jay
 * 1. 画图，背景和飞机
 * 2. 定义类：飞机类和子弹类
 * 3. 通过键盘控制飞机的移动
 * 	- 用内部类，使用外部类的普通属性
 *	- 重写keypresses和keyrelease
 *	- 重写launch方法。注册监听,父类的进行调用
 *	- 对p.x,p.y进行更新
 *	- 优化代码，飞机的方法封装到飞机类里面
 *
 *	- 进行提升到8个方向
 *	3.1 引入left, right, up, down 4个boolean量
 *		- move（），根据该四个值进行移动
 *		- 放入draw中，跟随重画
 *		- 更新keyEvent捕获，按下为true，释放为false
 *	3.2 优化，集成到飞机对象里面
 *	4.子弹类，
 *		- 多子弹？
 *			- ArrayList
 *		- 中心开花
 *		- 边界回弹
 *	5. 碰撞检测
 *		- 规则的矩形来进行处理,获取矩形
 *		- 检测矩形
 *	6. 封装游戏物体类
 *	7. 死
 *		- live 属性
 *		- 不画出来
 *		- 检测到碰撞
 *	8. 爆炸
 *		- 一堆图片加载,static ,共享
 */
public class PlaneGameFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/bg2.jpg");
	Plane p = new Plane("images/plane2.png", 50 , 50);
	ArrayList bulletList = new ArrayList();
	Exploit ex;
	
	Date startTime;
	Date endTime;
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		
		//4.1范性先不加
		for(int i = 0; i < bulletList.size();i++) {
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);	
			//检测和飞机的碰撞
			boolean peng = b.getRect().intersects(p.getRect());
			if(peng) {
				p.setLive(false);
				
				if(ex == null) {
					this.endTime = new Date();
					ex = new Exploit(p.x,p.y);
				}
				ex.draw(g);
				break;
			}
		}
		if(!p.isLive()) {
	
			int periods = (int)(this.endTime.getTime() - this.startTime.getTime()) / 1000;
			this.printInfo("生存时间：" + periods + "s", 20,g, 150,260,Color.WHITE);
			switch(periods / 10) {
			case 0:
				this.printInfo("菜鸟", 20, g, 100,200,Color.WHITE);
			}
		}
		
	}
	/**
	 * 在窗口上打印信息
	 * @param st
	 * @param size
	 * @param g
	 */
	public void printInfo(String st, int size, Graphics g, int x, int y, Color color) {
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("宋体", Font.BOLD,size);
		g.setFont(f);
		g.drawString(st, x, y);	
		g.setColor(c);
	}
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
		
	}
	

	@Override
	public void launchFrame() {
		super.launchFrame();
		//增加键盘监听
		this.addKeyListener(new KeyMonitor());
		
		//4.1生成子弹
		for(int i = 0; i < 50; i++) {
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		startTime = new Date();
		
	}


	//	d
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("按下" + e.getKeyCode());
//			p.move(e);
			/* 优化到plane里面
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				p.left = true;
				break;
			case KeyEvent.VK_RIGHT:
				p.right = true;
				break;
			case KeyEvent.VK_DOWN:
				p.down = true;
				break;
			case  KeyEvent.VK_UP:
				p.up = true;
				break;
			default:
					break;
			}
			*/
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			/*3.2集合到飞机里面
			System.out.println("释放" + e.getKeyCode());
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				p.left = false;
				break;
			case KeyEvent.VK_RIGHT:
				p.right = false;
				break;
			case KeyEvent.VK_DOWN:
				p.down = false;
				break;
			case  KeyEvent.VK_UP:
				p.up = false;
				break;
			default:
					break;
			}
			*/
			p.delDirection(e);
		}
		
	}
}
