package com.jay.java.Pattern.Strategy;
/**
 * 负责和具体的策略类分开
 * 客户端的调用和算法类分开，算法可以独立于客户端，
 * 如果使用Spring的依赖注入功能，可以通过配置文件，动态的注入不同策略对象，动态的切换不同算法
 * @author jay
 *
 */
public class Context {
	private Strategy strategy;//当前采用的算法
	/**
	 * 注入，构造器或者set方法
	 * @param strategy
	 */
	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	public void pringPrice(double s) {
		System.out.println("报价"+strategy.getPrice(s));
	}
	
}
