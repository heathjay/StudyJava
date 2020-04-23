package com.jay.java.Pattern.ChainOfResponsibility;
/**
 * 测试
 * @author jay
 *
 */
public class Client {
	public static void main(String[] args) {
		Leader a = new Director("a");
		Leader b = new Manager("b");
		Leader c = new GeneralManager("c");
		
		
		//组织责任链在客户端定义或者配置文件里面通过反射进行处理
		//责任链开始扩展，只需要增加类就可以了
		a.setNextLeader(b);
		b.setNextLeader(c);
		
		
		//开始请假操作
		Leaverequest req1 = new Leaverequest("jjsj", 10 ,"bb");
		a.handleRequest(req1);
	}
}
