package com.jay.java.Network.UTPTCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 专门处理数据的发送
 * - 一旦链接直接发送一个name
 * @author jay
 *
 */
public class ChatSend implements Runnable{
	//控制台输入流
	private BufferedReader console;
	//管道输出流
	private DataOutputStream dos;
	//线程标示
	private boolean isRunning = true;
	//4. 加入名字注册功能
	private String name;
	public ChatSend(Socket client, String name) {
		this();
		try {
			this.dos = new DataOutputStream(client.getOutputStream());
			this.name = name;
			send(this.name);
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dos,console);
		}
	}
	public ChatSend() {
		console = new BufferedReader(new InputStreamReader(System.in));
	}
	//从控制台接受数据
	private String getMsgFromConsole() {
		try {
			return console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	//发送信息
	public void send(String msg) {
		if(null != msg && !msg.equals("")) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				isRunning =false;
				CloseUtil.closeAll(dos,console);
			}
		}
	}
	
	
	
	@Override
	public void run() {
		while(isRunning) {
			send(getMsgFromConsole());
		}
	}

}
