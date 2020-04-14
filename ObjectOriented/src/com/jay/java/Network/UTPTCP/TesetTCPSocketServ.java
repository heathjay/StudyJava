package com.jay.java.Network.UTPTCP;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * TCP server
 * 1. 创建服务器并指定端口ServerSocket
 * 		 new ServerSocket(8888);
 * 2. 阻塞方法，接受客户端链接
 * 		Socket socket =  server.accept();
 * 		浏览器也是基于TCP的客户端 localhost:8888
 * 3. 接受数据  + 发送数据
 * 
 * - 接受多个客户端
 * 	- 聊天室的转发功能，服务器只负责转发
 * 	- 客户端可以发送数据，可以接受数据
 * 	- 每一个客户端创建一个线程
 * 	
 * 聊天室:
 * 	- 写出数据：输出流
 * 	- 读取数据：输入流
 * 1.0 
 * 	- 顺序输入，固定数据
 * 2.0
 * 	- 加入控制台输入流, 加入while循环读取控制台，但仍有写入顺序，输入流和输出流在同一个线程内，所以可以进行线程并行
 *3.0 
 *	- 服务器端多线程解决给每个用户一个管道
 * 	- 输入流输出流包装起来
 * 	- 写成内部类
 * 	- 加入容器进行管理其他的client，成员就开始遍历容器
 * 
 * 4.0 加入名称,
 * 	- 建立链接的一刹那，把name从控制台接收过来，并且用new Thread（new ChatSend（，name））
 * 
 * 5.0 @符号进行私聊
 * 
 * @author jay
 *
 */
public class TesetTCPSocketServ {
	private List<MyChannel> all = new ArrayList<MyChannel>();
	
	public static void main(String[] args) {
		new TesetTCPSocketServ().connect();
	}
	/**
	 * 基本链接传输
	 */
	public static void TestBase() {
		try {
			ServerSocket server = new ServerSocket(8888);
			Socket socket =  server.accept();
			System.out.println("one clinet has connected to the server");
			//send
			String msg = "欢迎";
			/*
			//获取输出流
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write(msg);
			bw.newLine();
			bw.flush();
			//不要关掉
			*/
			
			//换一个流
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void TestMutilClient() {
		try {
			ServerSocket server = new ServerSocket(8888);
			
			while(true) {
				// 一个accept一个客户端
				Socket socket = server.accept();
				System.out.println("一个客户端上线");
				String msg = "欢迎";
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(msg);
				dos.flush();
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void Chat2() {
		try {
			ServerSocket server = new ServerSocket(8888);
			Socket socket = server.accept();
			
			//输入流
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			//输出流
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			while(true) {				
				String msg = dis.readUTF();
				dos.writeUTF("服务器收到-" + msg);
				dos.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 3.0 一个客户端一个线程
	 * 1.输入流
	 * 2.输出流
	 * 3.接收数据
	 * 4.发送数据
	 * @author jay
	 *
	 */
	class MyChannel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning = true;
		private String name;
		public MyChannel(Socket client) {
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				this.name = dis.readUTF();
				send("欢迎进入聊天室");
				this.sendOther(this.name + "进入了聊天",true);
			} catch (IOException e) {
				CloseUtil.closeAll(dis,dos);
				isRunning = false;
				all.remove(this);
				this.sendOther(this.name + "离开",true);
			}
			
		}
		private String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				isRunning = false;
				CloseUtil.closeAll(dis);
				all.remove(this);
				this.sendOther(this.name + "离开",true);
			}
			return msg;
		}
		
		private void send(String msg) {
			if(null == msg || msg.equals("")) {
				return;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				isRunning = false;
				CloseUtil.closeAll(dos,dis);
				all.remove(this);
				this.sendOther(this.name + "离开",true);
			}
		}
		/**
		 * 发送给其他客户端
		 */
		private void sendOther(String msg, boolean sys) {
			//if是否私聊约定 如果有界面后台拼接
			if(msg.startsWith("@") && msg.indexOf(":") > -1)  {
				//获取name
				String name= msg.substring(1,msg.indexOf(":"));
				String content = msg.substring(msg.indexOf(":") + 1);
				for(MyChannel other:all) {
					if(other.name.equals(name)) {
						other.send(this.name + "私聊:" + content);
					}
				}
			}else {
				//遍历容器
				for(MyChannel other : all) {
					if(other == this) {
						continue;
					}
					if(sys) {
						//系统信息
						other.send("系统信息:" +msg); 
					}else {
						other.send(this.name + "对所有人说" +msg); 
					}
					}
					
			}		
		}
		@Override
		public void run() {
			while(isRunning) {
				//send(receive());
				sendOther(receive(),false);
			}
		}	
	}
	public void connect() {
		try {
			ServerSocket server = new ServerSocket(8888);
			while(true) {
				Socket client = server.accept();
				MyChannel channel = new MyChannel(client);
				all.add(channel);//加入到容器中统一管理
				new Thread(channel).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
