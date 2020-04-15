package com.jay.jave.ref;

import com.jay.java.Network.HttpsProject.MultiTaskUpdated.Servlet;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz = Class.forName("com.jay.java.Network.HttpsProject.MultiTaskUpdated.LoginServlet");
		Servlet src = (Servlet) clz.newInstance();
		
	}
	

}
