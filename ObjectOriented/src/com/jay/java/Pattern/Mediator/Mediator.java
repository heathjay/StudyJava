package com.jay.java.Pattern.Mediator;
/**
 * 中介者接口
 * @author jay
 *
 */
public interface Mediator {
	public void register(String dname, Department d);
	
	void command(String dname);
}
