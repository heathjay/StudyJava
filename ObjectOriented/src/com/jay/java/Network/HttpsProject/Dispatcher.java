package com.jay.java.Network.HttpsProject;

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
		
		Servlet server = new Servlet();
		server.servlet(req,rep);
		try {
			rep.pushToClient(code);//推送到客户端了
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			rep.pushToClient(500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseUtil.closeSocket(client);
		
	}
	
}
