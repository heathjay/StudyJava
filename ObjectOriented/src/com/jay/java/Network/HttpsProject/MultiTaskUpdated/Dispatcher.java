package com.jay.java.Network.HttpsProject.MultiTaskUpdated;

import java.io.IOException;
import java.net.Socket;

/**
 * 
 * @author jay
 *
 */
public class Dispatcher implements Runnable{
	private Request req;
	private Response rep;
	private Socket client;
	private int code = 200;
	public Dispatcher(Socket client) {
		this.client = client;
		try {
			req = new Request(client.getInputStream());
			rep = new Response(client.getOutputStream());
		} catch (IOException e) {
			code = 500;
			return;
		}
		
	}
	@Override
	public void run() {		
		try {
			Servlet server = WebApp.getServlet(req.getUrl());
			if(null == server) {
				this.code = 404;
			}else {
				server.service(req, rep);	
			}
			rep.pushToClient(code);//推送到客户端了
		}  catch (Exception e) {
			this.code = 500;
			e.printStackTrace();
		}
		try {
			rep.pushToClient(500);
		} catch (IOException e) {
			e.printStackTrace();
		}
		CloseUtil.closeSocket(client);
		
	}
	
}
