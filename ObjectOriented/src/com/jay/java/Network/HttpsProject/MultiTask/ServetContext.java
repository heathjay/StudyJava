package com.jay.java.Network.HttpsProject.MultiTask;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文
 * - 为每一个Servlet取一个别名
 * 		- login -->LoginServlet
 * 		- url -->login 多个url指向login
 * 			- /log->login
 * 			- /login -> login
 * @author jay
 *
 */
public class ServetContext {
	private Map<String,Servlet> servlet;
	private Map<String,String> mapping;
	
	
	public ServetContext() {
		this.servlet = new HashMap<String,Servlet>();
		this.mapping = new HashMap<String,String>();
	}
	public Map<String, Servlet> getServlet() {
		return servlet;
	}
	public void setServlet(Map<String, Servlet> servlet) {
		this.servlet = servlet;
	}
	public Map<String, String> getMapping() {
		return mapping;
	}
	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
}
