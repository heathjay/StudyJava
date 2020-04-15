package com.jay.java.Network.HttpsProject.MultiTaskUpdated;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

/**
 * 封装相应信息
 * @author jay
 *
 */
public class Response {
	private StringBuilder headInfo;
	private int len;
	private StringBuilder content;
	private BufferedWriter bw;
	public static final String CRLF="\r\n";
	public static final String BLACK = " ";
	/**
	 * 构建相应头
	 */
	public Response() {
		headInfo = new StringBuilder();
		len = 0;
		content = new StringBuilder();
	}
	public Response(OutputStream os) {
		this();
		bw = new BufferedWriter(new OutputStreamWriter(os));
		
	}
	public Response print(String info) {
		content.append(info);
		len+=info.getBytes().length;
		return this;
	}
	
	public Response println(String info) {
		content.append(info).append(CRLF);
		len+=(info + CRLF).getBytes().length;
		return this;
	}
	private void createHeadInfo(int code ) {
		//协议状态吗
		headInfo.append("HTTP/1.1").append(BLACK).append(code).append(BLACK);
		
		switch(code) {
		case 200:
			headInfo.append("OK");
			break;
		case 404:
			headInfo.append("Not Found");
			break;
		case 505:
			headInfo.append("SERVER EROOR");
			break;
		}
		headInfo.append(CRLF);
		//2. 头信息
		headInfo.append("Server:jay Server/0.1").append(CRLF);
		headInfo.append("Date").append(new Date()).append(CRLF);
		headInfo.append("Content-type:text/html;charset=UTF-8").append(CRLF);
		//正文的长度
		headInfo.append("Content-Length:").append(len).append(CRLF);
		headInfo.append(CRLF);
	}
	//推送
	void pushToClient(int code) throws IOException {
		if(null == headInfo) {
			code = 500;
		}
		createHeadInfo(code);
		//头信息+分隔符
		bw.append(headInfo.toString());
		bw.append(content.toString());
		bw.flush();
	}
	
	public void close() {
		CloseUtil.closeAll(bw);
	}
}
