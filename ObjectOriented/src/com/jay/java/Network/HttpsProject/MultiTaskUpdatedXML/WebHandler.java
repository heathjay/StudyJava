package com.jay.java.Network.HttpsProject.MultiTaskUpdatedXML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX 处理器编写比较麻烦
 * 存储对象
 * 	- 文档开始
 * 		- 元素开始
 * 		-元素结束
 * - 文档结束
 * - 字符处理
 * @author jay
 *
 */
public class WebHandler extends DefaultHandler{
	private List<Entity> entityList;
	private List<Mapping> mappingList;
	private String beginTag;//记录标签
	private Entity entity;
	private Mapping mapping;
	private boolean isMap;
		
	//处理文档开始
	@Override
	public void startDocument() throws SAXException {	
		entityList = new ArrayList<Entity>();
		mappingList = new ArrayList<Mapping>();
	}
	
	//元素开始
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if(null != qName) {
				beginTag=qName;
				if(qName.equals("servlet")) {
					this.isMap = false;
					entity =  new Entity();
				}else if(qName.equals("servlet-mapping")) {
					this.isMap = true;
					mapping = new Mapping();
				}
			}
		}
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {	
			
			if(null != beginTag) {
				String str = new String(ch,start, length);
			
				if(isMap) {
					if(beginTag.equals("servlet-name")) {
						mapping.setName(str);
					}else if(beginTag.equals("url-pattern")) {
						mapping.getUrlPattern().add(str);
					}
				}else {
					if(beginTag.equals("servlet-name")) {
						entity.setName(str);
					}else if(beginTag.equals("servlet-class")) {
						entity.setClz(str);
					}
				}
			}
			
		}
		//元素结束
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(null != qName) {
				if(qName.equals("servlet")) {
					entityList.add(entity);
				
				}else if(qName.equals("servlet-mapping")) {
					this.mappingList.add(mapping);
				}
				
			}
			beginTag=null;
		}
		
		
	
	public List<Entity> getEntityList() {
			return entityList;
		}

		public void setEntityList(List<Entity> entityList) {
			this.entityList = entityList;
		}

		public List<Mapping> getMappingList() {
			return mappingList;
		}

		public void setMappingList(List<Mapping> mappingList) {
			this.mappingList = mappingList;
		}

	//处理文档结束
	@Override
	public void endDocument() throws SAXException {
	}
	
	
}
