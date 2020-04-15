package com.jay.java.Network.HttpsProject.MultiTaskUpdatedXML;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class WebApp {
	private static ServetContext context;
	static {
		
		try {
			//获取工厂
					SAXParserFactory factory = SAXParserFactory.newInstance();	
					SAXParser parser = factory.newSAXParser();
					WebHandler web = new WebHandler();
					parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/jay/java/Network/HttpsProject/MultiTaskUpdatedXML/web.xml"), web);
		
					
					//将list转成map
					context = new ServetContext();
					Map<String,String> servlet = context.getServlet();
				
					for(Entity entity: web.getEntityList()) {
						//servlet-name servlet-class
						servlet.put(entity.getName(), entity.getClz());
					}
					Map<String,String> mapping = context.getMapping();
					for(Mapping mapp : web.getMappingList()) {
						//url-pattern - name
						List<String> urls = mapp.getUrlPattern();
						for(String url : urls) {
							mapping.put(url,mapp.getName());
						}
					}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(url.equals("") || url==null){
			return null;
		}
		
		//return context.getServlet().get(context.getMapping().get(url));
		//根据字符串创建对象
		String name = context.getServlet().get(context.getMapping().get(url));
		return (Servlet)Class.forName(name).newInstance();	//确认空构造存在
	}
}
