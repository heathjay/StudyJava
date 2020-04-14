package com.jay.java.Network.UTPTCP;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP
 * - 服务器	
 * 	- 创建服务器 DatagramSocket + 端口
 * 		- DatagramSocket server = new DatagramSocket(8888);
 * 	- 准备接受容器
 * 		- byte[] container = new byte[1024];
 * 	- 容器打包 DatagramPacket
 * 		- DatagramPacket packet = new DatagramPacket(container,container.length);
 * 	- 接受数据
 * 		- server.receive(packet);
 * 	- 分析数据
 * 		byte[] data = packet.getData();
			int len =packet.getLength();
			System.out.println(new String(data,0,len));
	- 关闭资源：server.close();
 *
 * 
 * - 接受DataType
 * 
 * @author jay
 *
 */
public class TestUDPTranServ {
	public static void main(String[] args) {
		 TestDataType();
	}
	/**
	 * 基本字节数组传输
	 */
	public static void TestServBase() {
		try {
			DatagramSocket server = new DatagramSocket(8888);
			byte[] container = new byte[1024];
			DatagramPacket packet = new DatagramPacket(container,container.length);
			server.receive(packet);
			//分析数据
			byte[] data = packet.getData();
			int len =packet.getLength();
			System.out.println(new String(data,0,len));
			server.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void TestDataType() {
		try {
			DatagramSocket server = new DatagramSocket(8888);
			byte[] container = new byte[1024];
			DatagramPacket packet = new DatagramPacket(container,container.length);
			server.receive(packet);
			//分析数据
			double data = (convert(packet.getData()));
			System.out.println(data);
			server.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double convert(byte[] data) {
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		double num = 0;
		try {
			num = dis.readDouble();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
}
