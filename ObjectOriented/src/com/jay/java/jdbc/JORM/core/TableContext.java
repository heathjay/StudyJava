package com.jay.java.jdbc.JORM.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.jay.java.jdbc.JORM.bean.ColumnInfo;
import com.jay.java.jdbc.JORM.bean.TableBean;
import com.jay.java.jdbc.JORM.utils.JavaFileUtils;
import com.jay.java.jdbc.JORM.utils.StringUtils;

/**
 * 负责获取管理数据库所有表结构和类结构，
 * @author jay
 *
 */
public class TableContext {
	/**
	 * 表名为key，表信息对象为value
	 */
	public static Map<String,TableBean> tables = new HashMap<String,TableBean>();
	/**
	 * 将po的对象和表信息对象国关联起来，便于重用
	 */
	public static Map<Class,TableBean> poClassTableMap = new HashMap<Class,TableBean>();
	
	private TableContext() {}
	
	static {
		
		Connection conn = DBManager.getMysqlConn();
		DatabaseMetaData dbmd;
		ResultSet Tableset;
		try {
			dbmd = conn.getMetaData();
			Tableset = dbmd.getTables(null, "%", "%", new String[] {"TABLE"});
			
			while(Tableset.next()) {
				String tableName = (String) Tableset.getObject("TABLE_NAME");
				TableBean ti = new TableBean(tableName, new ArrayList<ColumnInfo>(),new HashMap<String,ColumnInfo>());
				tables.put(tableName, ti);
				
				ResultSet set = dbmd.getColumns(null, "%", tableName, "%");//查询表中所有字段
				while(set.next()) {
					ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"),set.getString("TYPE_NAME"),0);
					ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
				}
				
				ResultSet set2 = dbmd.getPrimaryKeys(null, "%", tableName);
				while(set2.next()) {
					ColumnInfo ci2 = (ColumnInfo)ti.getColumns().get(set2.getObject("COLUMN_NAME"));
					ci2.setKeyType(1);
					ti.getPriKeys().add(ci2);
				}
				if(ti.getPriKeys().size() > 0) {
					ti.setOnlyPriKey(ti.getPriKeys().get(0));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//更新类结构
		updateJavaPOFile();
		
		//加载po包下面所有的类
		loadPOTable();
	}

	public static Map<String, TableBean> getTablesInfos() {
		return tables;
	}
	/**
	 * 实现了表结构，更新配置po包下面的java源代码
	 */
	public static void updateJavaPOFile() {
		Map<String,TableBean> map = TableContext.tables;
		for(TableBean t : map.values()) {
			JavaFileUtils.createJavaPOFile(t,new MySqlTypeConvert());
		}
	}
	
	/**
	 * 将po的class加载
	 */
	public static void loadPOTable() {
/*		Class c = Class.forName("com.jay.java.jdbc.JORM.po.Emp");
		poClassTableMap.put(c, tableInfo);*/
		
		for(TableBean t : tables.values()) {
			try {
				Class c = Class.forName(DBManager.getConf().getPoPackage() + "." + StringUtils.firstChar2UpperCase(t.getTname()));
				poClassTableMap.put(c, t);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
