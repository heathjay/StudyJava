package com.jay.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 批处理
 * - 尽量不处理preparedStatement
 *  - 可以使用Statement
 *  - 自动提交事务操作设置为false	conn.setAutoCommit(false);//设置为手动提交
 *  - statement.addBatch()
 *  - statement.executeBatch
 *  - conn.commit();
 * @author jay
 *
 */
public class TestManySql {
	public static void main(String[] args) {
		Connection conn =null;
		Statement stm = null;
		ResultSet set = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestName","root","jiang888");
			
			conn.setAutoCommit(false);//设置为手动提交
			
			stm = conn.createStatement();
			for(int i = 0; i < 2000;i++) {
				stm.addBatch("insert into Emp(username,pwd,regTime) values('ijs"+i+"',727272,now())");
			}
			stm.executeBatch();
			conn.commit();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			/**
			 * 后开的先关闭,
			 * 三个try-catch块状分开写
			 */
			try {
				if(set!=null) {
					set.close();
				}
				if(stm!=null) {
					stm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
