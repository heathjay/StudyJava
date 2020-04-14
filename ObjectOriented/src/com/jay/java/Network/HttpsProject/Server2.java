package com.jay.java.Network.HttpsProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * HTTP服务器
 * 1. 打印http协议
 * 	- ServerSocket + Socket + accept 
 * 	- BufferedReader 读取msg + StringBuilder.append(msg) + sb.append("/r/n")
 * 	- get requests
 * 
 * 2. html语言-
 * 	- 基本
 * 	- 表单
 * @author jay
 *
 */
public class Server2 {
	private ServerSocket server;
	public static void main(String[] args) {
		Server2 server = new Server2();
		server.start();

	}
	
	public void start() {	
		try {
			server = new ServerSocket(9999);
			String msg = null; // 接收客户端的请求信息
			
			
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		
	}
	private void receive() {
		try {
			Socket client = server.accept();
			String msg = null;	//接受客户端信息
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			while((msg = br.readLine()).length() > 0) {
				sb.append(msg);
				sb.append("\r\n");
				if(null == msg) {
					break;
				}
			}
			//客户端的请求信息
			String requestInfo = sb.toString().trim();//除去空格
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
