package com.jay.java.xml;

import java.util.ArrayList;
import java.util.List;

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
public class PersonHandler extends DefaultHandler{
	private List<Person> persons;
	private Person person;
	private String tag;//记录标签
	//处理文档开始
	@Override
	public void startDocument() throws SAXException {
		//System.out.println("处理文档开始");
		persons = new ArrayList<Person>();
	}
	//处理文档结束
	@Override
	public void endDocument() throws SAXException {
	}
	//元素开始
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(null != qName) {
			tag=qName;
		}
		
		if(null != qName && qName.equals("person")) {
			person = new Person();
		}
	}
	//元素结束
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("person")) {
			this.persons.add(person);
		}
		tag = null;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String str = new String(ch,start,length);
		if((null != tag)&& tag.equals("name") ) {
			person.setName(str);
		}else if((null != tag)&& tag.equals("age")) {
			Integer age = Integer.valueOf(str);
			person.setAge(age);
		}
	}
	public List<Person> getPersons(){
		return this.persons;
	}
}
