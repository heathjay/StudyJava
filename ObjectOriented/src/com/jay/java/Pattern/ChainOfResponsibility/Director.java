package com.jay.java.Pattern.ChainOfResponsibility;
/**
 * 主任
 * @author jay
 *
 */
public class Director extends Leader{

	@Override
	public void handleRequest(Leaverequest request) {
		if(request.getLeaveDays() < 3) {
			System.out.println("Director handles" + request.getEmpName() + request.getLeaveDays());
		}else {
			if(this.nextLeader != null) {
				this.nextLeader.handleRequest(request);
			}
		}
	}

	public Director(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}
