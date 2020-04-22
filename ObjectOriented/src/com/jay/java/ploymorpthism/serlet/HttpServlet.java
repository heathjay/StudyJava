package com.jay.java.ploymorpthism.serlet;
/**
 * 
 * 
 * @author jay
 * 多态2
 * server 小程序
 *
 */
public class HttpServlet {
	public void service() {
		System.out.println("Httpserver.service()");
		doGet();
	}
	
	public void doGet() {
		System.out.println("HttpServlet.doGet()");
	}
	
	public void doPost() {
		System.out.println("HttpServlet.doPost()");
	}


}
