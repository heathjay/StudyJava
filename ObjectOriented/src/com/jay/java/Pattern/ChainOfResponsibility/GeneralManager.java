package com.jay.java.Pattern.ChainOfResponsibility;
/**
 * 总经理
 * @author jay
 *
 */
public class GeneralManager extends Leader{

	@Override
	public void handleRequest(Leaverequest request) {
		if(request.getLeaveDays() < 30) {
			System.out.println("GeneralManager handles" + request.getEmpName() + request.getLeaveDays());
		}else {
			System.out.println("gg:" + request.getLeaveDays());
		}
	}

	public GeneralManager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}
