package com.jay.java.Network.HttpsProject;
/**
 * 加入类和多线程
 * - 代码处理，封装
 * - 定义一个线程类
 * - 根据不能业务逻辑处理
 * 	- 
 * @author jay
 *
 */
public class Servlet {
	public Servlet() {
		// TODO Auto-generated constructor stub
	}

	public void servlet(Request req, Response rep) {
		rep.println("<html><head> <title>HTTP 相应实例</title>");
		rep.println("</head><body>");
		rep.println("欢迎").println(req.getParameter("uname")).println("回来");
		rep.println("</body></html>");
	}
}
