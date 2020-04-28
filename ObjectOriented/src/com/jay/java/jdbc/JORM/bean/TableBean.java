package com.jay.java.jdbc.JORM.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 存储表结构的信息
 * @author jay
 *
 */
public class TableBean {
	/**
	 * 表名字
	 */
	private String tname;
	/**
	 * 字段信息
	 */
	private Map<String,ColumnInfo> columns;
	/**
	 * 唯一主键，目前只能处理表中只有一个主键的情况
	 */
	private ColumnInfo onlyPriKey;
	/**
	 * 联合主键
	 */
	private List<ColumnInfo> priKeys;
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}
	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}
	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}
	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}
	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}
	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}
	public TableBean(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey, List<ColumnInfo> priKeys) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
		this.priKeys = priKeys;
	}
	public TableBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TableBean(String tableName, ArrayList<ColumnInfo> arrayList, HashMap<String, ColumnInfo> hashMap) {
		super();
		this.tname = tableName;
		this.columns = hashMap;
		this.priKeys = arrayList;
	}
	
}
