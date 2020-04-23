package com.jay.java.Pattern.Command;

public interface Command {
	/**
	 * 批处理命令
	 * 实际项目中，根据需求设计多个方法
	 */
	void execute();
}


class ConcreteCommand implements Command{
	private Receiver receiver;//命令的真正执行者	
	@Override
	public void execute() {
		//可以记录日志
		System.out.println("before");
		receiver.action();
		System.out.println("after");
	}
	public ConcreteCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}
	
}