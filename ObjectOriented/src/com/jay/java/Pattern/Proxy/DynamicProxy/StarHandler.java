package com.jay.java.Pattern.Proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler{
	Star realStar;
	/**
	 * 
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj = null;
		
		System.out.println("方法执行前");
		System.out.println("谈合同，预付款");
		if(method.getName().equals("sing")) {			
			method.invoke(realStar, args);
		}
		System.out.println("方法之后");
		return null;
	}

	public StarHandler(Star realStar) {
		super();
		this.realStar = realStar;
	}
	

}
