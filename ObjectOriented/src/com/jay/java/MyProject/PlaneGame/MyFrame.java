package com.jay.java.MyProject.PlaneGame;
/**
 * 9.写一个父类进行继承
 */
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame{

	
	public void launchFrame() {
		//位置，
		this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
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
}
