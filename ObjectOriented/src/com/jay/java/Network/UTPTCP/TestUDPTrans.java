package com.jay.java.Network.UTPTCP;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 * UDP
 * - 客户端
 * 	- 创建客户端， DatagramSocket + 端口
 * 	- 准备数据 字节数组
 * 		- String msg = "udp编程";
			byte[] data = msg.getBytes();
 * 	- 打包 DatagramPacket类
 * 		-DatagramPacket 数据， InetSocketAddress（地点加上端口)
 * 		-new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
 * 
 * - 发送数据+ 类型
 * 	 - 8.99 类型转换 double - > 字节数组
 * @author jay
 *
 */
public class TestUDPTrans {
	public static void main(String args[]) {
		 TransDataType();
	}
		/**
		 * 基本字节数组传输
		 * 
		 */
	public static void TransBase() {
		try {
			DatagramSocket client = new DatagramSocket(9999);
			String msg = "udp编程";
			byte[] data = msg.getBytes();
			
			DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
			client.send(packet);
			client.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	public static void TransDataType() {
		try {
			DatagramSocket client = new DatagramSocket(9999);
			//准备数据
			double num = 8.99;
			byte[] data = convert(num);
			
			DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
			client.send(packet);
			client.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param num
	 * @return
	 */
	public static byte[] convert(double num) {
		byte data[] = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		//DataOutputStream dos = new DataOutputStream(new ByteArrayOutputStream
		try {
			dos.writeDouble(num);
			dos.flush();
			data = bos.toByteArray();
			dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}
}
