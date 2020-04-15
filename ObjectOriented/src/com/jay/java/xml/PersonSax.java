package com.jay.java.xml;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * SAX
 * @author jay
 *
 */
public class PersonSax {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		//获得解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//从解析工厂里面获得解析
		SAXParser parse = factory.newSAXParser();
		//用解析器加载处理器
		
		//编写处理器
		PersonHandler ph = new PersonHandler();
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/jay/java/xml/person.xml"),ph);
		List<Person> persons = ph.getPersons();
		for(Person tem:persons) {
			System.out.println(tem.getName()+tem.getAge());
		}
		
	}

}
