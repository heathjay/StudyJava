package com.jay.java.jdbc.JORM1.core;
/**
 * 1. mysql数据类型和java数据类型转换
 * @author jay
 *
 */
public class MySqlTypeConvert implements TypeConvert{

	@Override
	public String databaseType2JavaType(String columnType) {
		//varchar -->String
		if("varchar".equalsIgnoreCase(columnType) || "char".equalsIgnoreCase(columnType)) {
			return "String";
		}else if("int".equalsIgnoreCase(columnType)
				||"tinyint".equalsIgnoreCase(columnType)
				||"smallint".equalsIgnoreCase(columnType)
				||"integer".equalsIgnoreCase(columnType)
				) {
			return "Integer";
		}else if("bigint".equalsIgnoreCase(columnType)) {
			return "Long";
		}else if("double".equalsIgnoreCase(columnType) || "float".equalsIgnoreCase(columnType)) {
			return "Double";
		}else if("clob".equalsIgnoreCase(columnType)) {
			return "java.sql.Clob";
		}else if ("blob".equalsIgnoreCase(columnType)) {
			return "java.sql.Blob";
		}else if ("date".equalsIgnoreCase(columnType)) {
			return "java.sql.Date";
		}else if ("time".equalsIgnoreCase(columnType)) {
			return "java.sql.Time";
		}else if ("timestamp".equalsIgnoreCase(columnType)) {
			return "java.sql.TimeStamp";
		}
		return null;
	}

	@Override
	public String javaType2databaseType(String javadataType) {
		
		return null;
	}
	
}
