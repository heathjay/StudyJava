package com.jay.java.Network.UTPTCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 接受线程
 * @author jay
 *
 */
public class ChatReceive implements Runnable{
	private DataInputStream dis;
	private boolean isRunning = true;
	public ChatReceive() {
	}

	public ChatReceive(Socket client) {
		try {
			this.dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
	}
	/**
	 * 接受数据
	 * @return
	 */
	public String receive() {
		String msg = "";
		
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
		return msg;
		
	}
	@Override
	public void run() {	
		while(isRunning) {
			System.out.println(this.receive());
		}
		
	}

}
