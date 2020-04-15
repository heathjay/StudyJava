package com.jay.java.Network.HttpsProject.MultiTaskUpdatedXML;

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
 * - 4.1 封装相应信息
 * - 5.1 封装请求方式
 * - 7.1 加入多线程， 分发WebApp， ServetContext不同业务逻辑，抽象类Servlet，具体业务逻辑处理LoginServlet，RegisterServlet
 * - 8.1 在ServetContext 开始存字符串而不是类
 * 	- 反射：动态语言：在运行期间随意改变对象的类型 + 架构ruby js
 * 	- java不是动态语言，但由动态属性
 * 		- 1. 反射，镜子
 * 		- 2. 在编译器创建对象，new 完整类名， 反射：通过对象找出类名
 * 		- 3. jvm在创建时自动生成与之对应的Class对象，同一个类的多个对象在jvm只有一个对应的class对象
 * 		- class	
 * 			- 可以看成类的元数据，每一个对象在创建时jvm会自动生成一个与之对应的class，同类型的对象对应一个class
 * 			- 获取class对象的三种方式：
 * 				- Object的getClass方法。
 * 				- 类.class	
 * 				- 常用class类的静态方法, class.forName("完整类名+路径")，空构造必须存在
 * - 9.1 加入配置文件xml - extensible markup language
 * @author jay
 *
 */
public class Server9 {
	private ServerSocket server;
	
	private boolean isShutdown= false;
	public static void main(String[] args) {
		Server9 server = new Server9();
		server.start();

	}
	
	public void start() {	
		start(8888);
	}
	
	public void start(int port) {	
		try {
			server = new ServerSocket(port);		
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
			this.isShutdown= false;
			stop();
		}
	}
	
	public void stop() {
		this.isShutdown = true;
		CloseUtil.closeSocket(server);
	}
	private void receive() {
		try {
			while(!this.isShutdown) {
				new Thread(new Dispatcher(server.accept())).start();
			}
			
		} catch (IOException e) {
			stop();
		}
	}

}
