package com.jay.java.Thread.TestFirst;
/**
 * 静态代理设计模式
 * 1. 真是角色
 * 2. 代理角色:要持有真实角色的引用
 * 3. 二者要实现相同的接口
 * @author jay
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		//创建真实角色
		Marry you = new You();
		//持有真实角色
		WeddingCompany company = new WeddingCompany(you);
		
		company.marry();
	}
}

interface Marry{
	public abstract void marry();
}
//真实角色
class You implements Marry{

	@Override
	public void marry() {
		System.out.println("you and me ");
	}
	
}
//代理角色
class WeddingCompany implements Marry{
	private Marry you;
	
	public WeddingCompany() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WeddingCompany(Marry you) {
		super();
		this.you = you;
	}
	private void before() {
		System.out.println("ready");
	}
	private void after() {
		System.out.println("done");
	}
	@Override
	public void marry() {
		you.marry();	
	}
	
}