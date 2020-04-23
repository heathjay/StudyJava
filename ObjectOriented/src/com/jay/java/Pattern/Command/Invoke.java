package com.jay.java.Pattern.Command;
/**
 * 调用者
 * @author jay
 *
 */
public class Invoke {
	//可以通过一个list包含多个commands
	private Command command;

	public Invoke(Command command) {
		super();
		this.command = command;
	}
	
	public void call() {
		//调用命令前或者后可以进行批处理
		command.execute();
	}
}
