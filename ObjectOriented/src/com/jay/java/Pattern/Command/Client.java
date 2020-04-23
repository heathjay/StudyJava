package com.jay.java.Pattern.Command;
/**
 * 实验
 * 扩展性更强
 * @author jay
 *
 */
public class Client {
	public static void main(String[] args) {
		Command c = new ConcreteCommand(new Receiver());
		
		Invoke i = new Invoke(c);
		i.call();
		
		
		
	}
}
