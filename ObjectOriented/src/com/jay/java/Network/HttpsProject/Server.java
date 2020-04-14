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
 * 
 * 2.0 修改接收信息方式不采用BUfferedReader 
 * 		- 	byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
 * 3.0 处理请求
 * 		- 分清请求方式
 * 	- HTTP包含：
 * 		- 请求方法： 方法  URL 协议/版本
 * 		- 请求头： 客户端环境和请求正文的有用信息，如浏览器所用语言，请求正文的长度等等
 * 		- 请求正文（Request Content）：请求头和请求正文之间必须存在CRLF\r\n符号行。与请求头分开，这个行很重要说明请求头已经结束
 * 		- 接下来就是正文，post方式的数据存放与正文中间，请求正文中包含用户提供的查询字符串信息
 * 	- 响应格式
 * 		- HTTP协议版本，状态吗，描述
 * 		- 响应头：正文类型，编码格式，日期，正文长度-字节数，
 * 		- 响应正文
 * 
 * @author jay
 *
 */
public class Server {
	private ServerSocket server;
	public static void main(String[] args) {
		Server server = new Server();
		while(true) {
			server.start();
		}


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

			byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
			
			
			//客户端的请求信息
			String requestInfo = new String(data,0,len).trim();//除去空格
			System.out.println(requestInfo);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
