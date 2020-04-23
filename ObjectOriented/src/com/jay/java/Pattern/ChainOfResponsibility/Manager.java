package com.jay.java.Pattern.ChainOfResponsibility;
/**
 * 经理
 * @author jay
 *
 */
public class Manager extends Leader{

	@Override
	public void handleRequest(Leaverequest request) {
		if(request.getLeaveDays() < 10) {
			System.out.println("Manager handles" + request.getEmpName() + request.getLeaveDays());
		}else {
			if(this.nextLeader != null) {
				this.nextLeader.handleRequest(request);
			}
		}
	}

	public Manager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}
