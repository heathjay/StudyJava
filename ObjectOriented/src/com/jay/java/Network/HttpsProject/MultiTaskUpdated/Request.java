package com.jay.java.Network.HttpsProject.MultiTaskUpdated;
/**
 * 5.1封装请求方式
 * @author jay
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Request {
	//请求方式 
	private String method;
	//请求资源
	private String url;
	//请求参数
	private Map<String,List<String>> parameterMapValue;
	//内部
	public static final String CRLF = "\r\n";
	private InputStream is;
	private String requestInfo;
	
	public Request() {
		method = "";
		url = "";
		parameterMapValue = new HashMap<String,List<String>>();
		requestInfo = "";	
	}
	
	public Request(InputStream is) {
		this();
		this.is = is;
		try {
			byte[] data = new byte[20480];
			int len = is.read(data);
			requestInfo = new String(data,0,len);
		} catch (IOException e) {
			return;
		}
		
		//分析头信息；
		parseRequestInfo();
	}
	/**
	 * 分析头信息
	 */
	private void parseRequestInfo() {
		if(null == requestInfo ||(requestInfo = requestInfo.trim()).equals("")) {
			return;
		}
		
		/**
		 * ====================================
		 * 从信息首行分界出：请求方式，请求路径，请求参数 (get 可能存在）
		 * 如：
		 * GET /index.html?name=1234pwd=231 HTTP/1.1
		 * 如果是POST方式请求参数可能在最后正文中
		 * 
		 * =======================================
		 */
		String paramString = "";
		//1. 获取请求方式
		String firline = requestInfo.substring(0,requestInfo.indexOf(CRLF));
		int idx = requestInfo.indexOf(" /");
		this.method = firline.substring(0,idx);
		String urlStr=firline.substring(idx,firline.indexOf(" HTTP"));
		if(this.method.equals("POST")) {
			this.url = urlStr;
			paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
		}else if(this.method.equals("GET")) {
			if(urlStr.contains("?")) {
				String[] urlArray = urlStr.split("\\?");
				this.url= urlArray[0];
				paramString = urlArray[1];//接受某方法
			}else {
				this.url = urlStr;
			}
		}
		//2.请求参数封装到map中
		if(paramString.equals("")) {
			return;
		}
		parseParams(paramString);
	
	}
	
	private void parseParams(String paramString) {
		//分割
		//String[] data = paramString.split("&&");
		StringTokenizer token = new StringTokenizer(paramString,"&");
		while(token.hasMoreTokens()) {
			String keyValue = token.nextToken();
			String[] keyValues = keyValue.split("=");
			if(keyValues.length==1) {
				keyValues = Arrays.copyOf(keyValues, 2);
				keyValues[1] = null;
				
			}
			String key = keyValues[0].trim();
			String value = null ==keyValues[1]?null:decode(keyValues[1].trim(),"UTF-8");
			//转换成map
			if(!this.parameterMapValue.containsKey(key)) {
				this.parameterMapValue.put(key,new ArrayList<String>());
				
			}
			List<String> values = this.parameterMapValue.get(key);
			values.add(value);
		}
	}
	/**
	 * 格局页面的name获取对应的值
	 * @param args
	 */
	
	public String[] getParameterValues(String name) {
		List<String> values = null;
		if((values=this.parameterMapValue.get(name)) == null) {
			return null;
		}else {
			return values.toArray(new String[0]);
		}
	}
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		if(null == values) {
			return null;
		}
		return values[0];
	}
	
	/**
	 * 解码,解决中文的问题
	 */
	
	private String decode(String values, String code) {
		try {
			return java.net.URLDecoder.decode(values, code);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String getUrl() {
		return this.url.trim();
	}
}
