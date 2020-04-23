package com.jay.java.Pattern.ChainOfResponsibility;



/**
 * 抽象类：leader
 * @author jay
 *
 */
public abstract class Leader {
	protected String name;
	protected Leader nextLeader;//后面的领导对象，
	public Leader(String name) {
		super();
		this.name = name;
	}
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
	public abstract void handleRequest(Leaverequest request);
}
