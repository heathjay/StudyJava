package com.jay.java.Network.UTPTCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP
 * - 面向链接Socket
 * 1. 创建客户端，指定服务器端加上端口，此时就在链接,客户端端口系统分配
 * 2. 发送数据
 * 
 * 
 * - 聊天室
 * 	- 输入流
 * 	- 输出流
 * - 2. 加入线程区分ChatSend输入流和输出流ChatReceive
 * 		
 * @author jay
 *
 */
public class TestTCPSocketClient {

	public static void main(String[] args) {
		try {
			System.out.println("请输入名称");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String name = br.readLine();
			if(name.equals("")) {
				return;
			}
			Socket client = new Socket("localhost",8888);
			new Thread(new ChatSend(client,name)).start();
			new Thread(new ChatReceive(client)).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 基本链接和接受数据
	 */
	public static void TestBase() {
		try {
			Socket client = new Socket("localhost",8888);
			
			/*
			//接受数据
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			//阻塞方法
			String echo = br.readLine();
			System.out.println(echo);
			*/
			
			DataInputStream dis = new DataInputStream(client.getInputStream());
			String echo = dis.readUTF()	;
			System.out.println(echo);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public static void Chat1() {
		try {
			Socket client = new Socket("localhost",8888);
			//控制台输入流
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			//输出流
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			//输入流
			DataInputStream dis = new DataInputStream(client.getInputStream());
			while(true) {
				String info = console.readLine();
				//dos.writeUTF("数据");
				dos.writeUTF(info);
				dos.flush();
				//读入数据
				String msg = dis.readUTF();
				System.out.println(msg);
			}
			
			//写出数据
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
