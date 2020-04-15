package com.jay.java.Network.HttpsProject.MultiTaskUpdated;

import java.util.Map;

public class WebApp {
	private static ServetContext context;
	static {
		context = new ServetContext();
		


		Map<String,String> mapping = context.getMapping();
		mapping.put("/login", "login");
		mapping.put("/log", "login");
		mapping.put("/reg", "register");

		Map<String,String> servlet = context.getServlet();
		servlet.put("login","com.jay.java.Network.HttpsProject.MultiTaskUpdated.LoginServlet");
		servlet.put("register","com.jay.java.Network.HttpsProject.MultiTaskUpdated.RegisterServlet");
	}
	
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(url.equals("") || url==null){
			return null;
		}
		
		//return context.getServlet().get(context.getMapping().get(url));
		//根据字符串创建对象
		String name = context.getServlet().get(context.getMapping().get(url));
		return (Servlet)Class.forName(name).newInstance();	//确认空构造存在
		
	}
}
