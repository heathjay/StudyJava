package com.jay.java.Network.HttpsProject.MultiTaskUpdatedXML;

public class LoginServlet extends Servlet{

	@Override
	public void doGet(Request req, Response rep) throws Exception {
		
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		if(login(name,pwd)) {
			rep.println("<html><head> <title>欢迎回来</title>");
			rep.println("</head><body>");
			rep.println("欢迎").println(req.getParameter("uname")).println("登陆成功");
			rep.println("</body></html>");
		}else {
			rep.println("<html><head> <title>失败</title>");
			rep.println("</head><body>");
			rep.println("欢迎").println(req.getParameter("uname")).println("登陆失败");
			rep.println("</body></html>");
		}
		
	}
	
	
	public boolean login(String name,String pwd) {
		return name.equals("jay") && pwd.equals("1");
	}
	@Override
	public void doPost(Request req, Response rep) throws Exception {
		
	}

}
