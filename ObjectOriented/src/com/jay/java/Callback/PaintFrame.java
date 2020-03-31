package com.jay.java.Callback;
/**
 * 
 * @author jay
 * hook
 * callback
 *
 */
public class PaintFrame {
	public static void drawFrame(MyFrame f) {
		System.out.println("启动线程");
		System.out.println("增加循环");
		System.out.println("查看消息栈");
		
		//画窗口，每次都不一样
		//传不同的子类对象，可以实现paint方法不一样
		//先写死，回调
		//
		f.paint();
		
		//问题paint - 画的方式不一样，参考网页
	}
	
	public static void main(String[] args) {
		drawFrame(new GameFrame01());
	}
}

class GameFrame01 extends MyFrame{
	public void paint() {
		System.out.println("GameFrame01.paint()");
	}
}

class GameFrame02 extends MyFrame{
	public void paint() {
		System.out.println("GameFrame01.paint()");
	}
}