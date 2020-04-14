package com.jay.java.Network.UTPTCP;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * IntetSocketAddress
 * 包含端口： 在InetAddress基础上+端口
 * - new InetSocketAddress("localhost", 9999);
 * @author jay
 *
 */
public class TestInetSocket {
	public static void main(String[] args) throws UnknownHostException {
		InetSocketAddress addr = new InetSocketAddress("localhost", 9999);
		addr = new InetSocketAddress(InetAddress.getByName("localhost"), 10000);
		System.out.println(addr.getHostName());
		System.out.println(addr.getPort());
		InetAddress add = addr.getAddress();
		System.out.println(add.getHostAddress());
		System.out.println(add.getHostName());
	}
}
