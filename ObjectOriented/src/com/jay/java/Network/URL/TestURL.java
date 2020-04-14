package com.jay.java.Network.URL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL
 * - new URL(绝对路径|相对路径: 协议，主机域名，端口，资源名)
 * - 协议: url.getProtocol()
 * - 域名： url.getHost()
 * - 端口： url.getPort()
 * - 资源： url.getFile()
 * - 路径 ： "相对路径：" + url.getPath()
 * - 锚点：url.getRef()
 * - 参数： url.getQuery());//?参数：存在返回null，不存在锚点，返回正确的参数、
 * 
 * - 获取资源：源代码
 * 	- InputStream is = url.openStream();
 * 	- 使用转换流
 * 		- BufferedReader  = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
 * @author jay
 *
 */
public class TestURL {

	public static void main(String[] args) throws IOException {
		
	}
	/**
	 * 1.基本方法测试
	 * @throws MalformedURLException
	 */
	public static void TestBaseFuc() throws MalformedURLException {
		URL url = null;
		//绝对路径
		try {
			url = new URL("http://www.baidu.com:80/index.html#aa");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//绝对路径
		url = new URL("http://www.baidu.com:80/a/");
		//相对
		url = new URL(url,"b.txt");
		System.out.println(url);
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getFile());
		//用的比较多
		System.out.println("相对路径：" + url.getPath());
		System.out.println("锚点：" + url.getRef());
		System.out.println("参数：" + url.getQuery());//?参数：存在返回null，不存在锚点，返回正确的参数
		
	}
	public static void getResource() throws UnsupportedEncodingException, IOException {
		URL url = new URL("http://www.baidu.com"); // 默认资源
		/*	
			//获取资源
			InputStream is = url.openStream();
			byte[] flush  = new byte[1024];
			int len = 0;
			while(-1 != (len = is.read(flush))) {
				System.out.println(new String(flush,0,len));
			}
			is.close();*/
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(url.openStream(),"utf-8"));
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),"utf-8")); 
			String msg = null;
			while((msg=br.readLine())!=null) {
				//System.out.println(msg);
				bw.append(msg);
				bw.newLine();
			}
			bw.flush();
			bw.close();
			br.close();
	}

}
