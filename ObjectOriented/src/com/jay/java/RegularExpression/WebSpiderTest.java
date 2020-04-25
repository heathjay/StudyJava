package com.jay.java.RegularExpression;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网络爬虫
 * @author jay
 *
 */
public class WebSpiderTest {
	public static String getURLContent(String URL) {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = null;
		try {
			URL url = new URL(URL);
			reader = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName("gbk")));
			
			String temp = "";
			while((temp=reader.readLine())!= null) {
				sb.append(temp);
				
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
	public static List<String> getMatcherSubStrs(String destStr,String regexStr){
		
		//超链接整个内容	
			//Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");
			//Pattern p = Pattern.compile("href=\".+?\"");
//			Pattern p = Pattern.compile("href=\"(.+?)\"");
			Pattern p = Pattern.compile(regexStr);
			Matcher m = p.matcher(destStr);
			List<String> list = new ArrayList<String>();
			while(m.find()) {
				list.add(m.group(1));
			}
			return list;
	}
	public static void main(String[] args) {
		String destStr = getURLContent("http://www.163.com");
		String regexStr = "href=\"([\\w\\s./:]+?)\"";
		List<String> list = getMatcherSubStrs(destStr,regexStr);
		for(String temp : list) {
			System.out.println(temp);	
		}
		
	}
}
