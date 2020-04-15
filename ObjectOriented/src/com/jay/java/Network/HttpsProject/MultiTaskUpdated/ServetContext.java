package com.jay.java.Network.HttpsProject.MultiTaskUpdated;

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
	//存字符串 com.jay.java.Network.HttpsProject.MultiTaskUpdated.LoginServlet
	/**
	 * 
	 */
	private Map<String,String> servlet;
	
	private Map<String,String> mapping;
	
	
	public ServetContext() {
		this.servlet = new HashMap<String,String>();
		this.mapping = new HashMap<String,String>();
	}
	public Map<String, String> getServlet() {
		return servlet;
	}
	public void setServlet(Map<String, String> servlet) {
		this.servlet = servlet;
	}
	public Map<String, String> getMapping() {
		return mapping;
	}
	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
}
