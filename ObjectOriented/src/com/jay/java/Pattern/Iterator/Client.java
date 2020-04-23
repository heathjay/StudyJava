package com.jay.java.Pattern.Iterator;

public class Client {
	public static void main(String[] args) {
		ConcreteMyAggregate cma = new ConcreteMyAggregate();
		cma.addObject("sss");
		cma.addObject("xxxx");
		cma.addObject("huhsu");

		MyIterator it = cma.createIterato();
		while(it.hasNext()) {
			System.out.println(it.getCurrentObj());
			it.next();
		}
	}
}
