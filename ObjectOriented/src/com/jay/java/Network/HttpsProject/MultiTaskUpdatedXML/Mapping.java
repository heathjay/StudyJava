package com.jay.java.Network.HttpsProject.MultiTaskUpdatedXML;

import java.util.ArrayList;
import java.util.List;

/**
 * 用来存储mapping
 * <servlet-mapping>
		<servlet-name>login</servlet-name>
		<url-pattern>/login</url-pattern>
	</servlet-mapping>
 * @author jay
 *
 */
public class Mapping {
	private String name;
	private List<String> urlPattern;
	public Mapping() {
		urlPattern = new ArrayList<String>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getUrlPattern() {
		return urlPattern;
	}
	public void setUrlPattern(List<String> urlPattern) {
		this.urlPattern = urlPattern;
	}
	
}