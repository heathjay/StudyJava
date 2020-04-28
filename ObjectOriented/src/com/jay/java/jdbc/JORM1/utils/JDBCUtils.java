package com.jay.java.jdbc.JORM1.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装了JDBC查询常用操作
 * @author jay
 *
 */
public class JDBCUtils {
	/**
	 * 给sql设参数
	 * @param ps
	 * @param params
	 */
	public static void handleParams(PreparedStatement ps, Object[] params) {
		if(params != null) {
			//给sql社参数
			for(int i = 0 ; i < params.length;i++) {
				try {
					ps.setObject(1+i, params[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
