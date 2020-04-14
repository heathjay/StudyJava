package com.jay.java.Network.HttpsProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
* HTTP服务器
 * 1. 打印http协议
 * 	- ServerSocket + Socket + accept 
 * 	- BufferedReader 读取msg + StringBuilder.append(msg) + sb.append("/r/n")
 * 	- get requests
 * 
 * 2. html语言-
 * 	- 基本
 * 	- 表单
 * 
 * 2.0 修改接收信息方式不采用BUfferedReader 
 * 		- 	byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
 * 3.0 处理请求
 * 		- 分清请求方式
 * 	- HTTP包含：
 * 		- 请求方法： 方法  URL 协议/版本
 * 		- 请求头： 客户端环境和请求正文的有用信息，如浏览器所用语言，请求正文的长度等等
 * 		- 请求正文（Request Content）：请求头和请求正文之间必须存在CRLF\r\n符号行。与请求头分开，这个行很重要说明请求头已经结束
 * 		- 接下来就是正文，post方式的数据存放与正文中间，请求正文中包含用户提供的查询字符串信息
 * 	- 响应格式
 * 		- HTTP协议版本，状态吗，描述
 * 			- 1xxx 信息类，标示Web浏览器请求，正进一步处理
 * 			- 2xxx 成功类，表示用户请求被正确接受理解和处理
 * 			- 3xxx重定向，表示请求没有成功，客户必须采取进一步措施
 * 			- 4xxx客户端错误，表示客户端提交的请求有错误
 * 			- 5xxx服务器错误，服务器不能完成对请求的处理
 * 			
 * 		- 响应头：正文类型，编码格式，日期，正文长度-字节数，
 * 			- Content-Type:text/html;charset=UTF-8  Content-Length: bytes[]
 * 		- 响应正文
 * 
 * @author jay
 *
 */
public class Server3 {
	private ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLACK = " ";
	public static void main(String[] args) {
		Server3 server = new Server3();
		server.start();

	}
	
	public void start() {	
		try {
			server = new ServerSocket(9999);
			String msg = null; // 接收客户端的请求信息
			
			
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		
	}
	private void receive() {
		try {
			Socket client = server.accept();
			String msg = null;	//接受客户端信息

			byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
				
			//客户端的请求信息
			String requestInfo = new String(data,0,len).trim();//除去空格
			System.out.println(requestInfo);
			
			//相应
			StringBuilder responseContext = new StringBuilder();
			responseContext.append("<html><head> <title>HTTP 相应实例</title></head>"
					+ "<body>Hello sss</body></html>");
			
			StringBuilder response = new StringBuilder();
			//协议状态吗
			response.append("HTTP/1.1").append(BLACK).append("200").append(BLACK).append("OK").append(CRLF);
			//2. 头信息
			response.append("Server:jay Server/0.1").append(CRLF);
			response.append("Date").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=UTF-8").append(CRLF);
			//正文的长度
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			//正文之前
			response.append(CRLF);
			response.append(responseContext);
			
			System.out.println(response.toString());
			//输出
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
