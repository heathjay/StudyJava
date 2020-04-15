package com.jay.java.Network.HttpsProject.MultiTaskUpdated;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 关闭流的方法
 * @author jay
 *
 */
public class CloseUtil {
	public static void closeAll(Closeable ...io) {
		for(Closeable temp : io) {
			if(null != temp) {
				try {
					temp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void closeSocket(Socket... client) {
		for(Socket tmp : client) {
			if( null != tmp) {
				try {
					tmp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void closeSocket(ServerSocket... server) {
		for(ServerSocket tmp : server) {
			if( null != tmp) {
				try {
					tmp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
