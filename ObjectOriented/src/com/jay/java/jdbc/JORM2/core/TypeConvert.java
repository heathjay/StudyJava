package com.jay.java.jdbc.JORM2.core;
/**
 * 负责java数据类型和数据库类型相互转换
 * @author jay
 *
 */
public interface TypeConvert {
	/**
	 * 数据库类型到java
	 * @param columnType
	 * @return
	 */
	public String databaseType2JavaType(String columnType);
	/**
	 * 将java数据类型转换为数据库数据类型
	 * @param javadataType
	 * @return
	 */
	public String javaType2databaseType(String javadataType);
}
