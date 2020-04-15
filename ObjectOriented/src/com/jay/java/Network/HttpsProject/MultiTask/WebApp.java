package com.jay.java.Network.HttpsProject.MultiTask;

import java.util.Map;

public class WebApp {
	private static ServetContext context;
	static {
		context = new ServetContext();
		


		Map<String,String> mapping = context.getMapping();
		mapping.put("/login", "login");
		mapping.put("/log", "login");
		mapping.put("/reg", "register");

		Map<String,Servlet> servlet = context.getServlet();
		servlet.put("login",new LoginServlet());
		servlet.put("register",new RegisterServlet());
	}
	
	public static Servlet getServlet(String url) {
		if(url.equals("") || url==null){
			return null;
		}
		System.out.println(url);
		return context.getServlet().get(context.getMapping().get(url));
	}
}
