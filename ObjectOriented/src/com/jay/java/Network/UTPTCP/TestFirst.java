package com.jay.java.Network.UTPTCP;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress
 * - InetAddress.getLocalHost();
 * - InetAddress.getByName("www.163.com");
 * - getHostAddress()
 * - .getHostName()
 * 
 * 没有封装端口
 * @author jay
 *
 */
public class TestFirst {
	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress addr = InetAddress.getLocalHost();
		
		System.out.println(addr);
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		
		//互联网上
		//用域名查找,.getHostAddress - IP
		// .getHostName-
		addr = InetAddress.getByName("www.163.com");
		System.out.println(addr);
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		
		addr = InetAddress.getByName("163.171.132.119");
		System.out.println(addr);
		System.out.println(addr.getHostAddress());
		//解析的了就发www.163.com 解析不了就发ip
		System.out.println(addr.getHostName());
	}
}
