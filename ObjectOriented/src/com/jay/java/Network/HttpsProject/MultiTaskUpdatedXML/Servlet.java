package com.jay.java.Network.HttpsProject.MultiTaskUpdatedXML;
/**
 * 加入类和多线程
 * - 代码处理，封装
 * - 定义一个线程类
 * - 根据不能业务逻辑处理
 * 	- 7.1 工厂模式
 * 		- 抽象成一个抽象类
 * @author jay
 *
 */
public abstract class Servlet {
	public Servlet() {
	}
	public abstract void doGet(Request req, Response rep) throws Exception;
	public abstract void doPost(Request req, Response rep) throws Exception;
	public void service(Request req, Response rep) throws Exception{
		this.doGet(req,rep);
		this.doPost(req,rep);
	}
}
