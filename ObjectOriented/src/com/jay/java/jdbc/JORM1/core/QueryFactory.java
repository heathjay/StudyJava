package com.jay.java.jdbc.JORM1.core;
/**
 * 返回相应的query对象, 通过工厂来建立Query对象
 * @author jay
 *
 */
public class QueryFactory {
	/**
	 * 单例模式
	 */
	private static QueryFactory factory = new QueryFactory();
	private static Query prototypeObj;	//原型对象
	static {
		

		
		
		
		
		try {
			 Class c = Class.forName(DBManager.getConf().getQueryClass());
			//Class c = Class.forName("com.jay.java.jdbc.JORM1.core.MySqlQuery");
			 prototypeObj = (Query) c.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private QueryFactory() {
		
	}
	public static Query createQuery() {
		
		/*try {
			return (Query)c.newInstance();//可能降低效应
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}*/
		try {
			return (Query) prototypeObj.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
