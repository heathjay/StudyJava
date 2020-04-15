package com.jay.java.Network.HttpsProject.MultiTaskUpdatedXML;
/**
 * 用来存储
 * <servlet>
		<servlet-name>login</servlet-name>
		 <servlet-class>com.jay.java.Network.HttpsProject.MultiTaskUpdated.LoginServlet</servlet-class>
	</servlet>
 * @author jay
 *
 */
public class Entity {
	private String name;
	private String clz;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClz() {
		return clz;
	}
	public void setClz(String clz) {
		this.clz = clz;
	}
	
}
