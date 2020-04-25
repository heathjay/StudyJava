package com.jay.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试事务
 * - transaction
 * @author jay
 *
 */
public class TestEvent {
	public static void main(String[] args) {
		Connection conn =null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet set = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestName","root","jiang888");
			//jdbc会自动提交，conn关闭的时候
			conn.setAutoCommit(false);
			
			String sql = "insert into Emp(username,pwd) values(?,?)";
			//事务开始
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "iquiu");
			ps.setObject(2,	 "suhuqhu");
			ps.execute();
			
			Thread.sleep(3000);
				//故意失败
			ps1 = conn.prepareStatement("insert into Emp(username,pwd) values(?,?,?)");
			ps1.setObject(1, "iqhshsuiu");
			ps1.setObject(2,"1278378");
			ps1.execute();
			
			
			conn.commit();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (InterruptedException e) {
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
					if(ps!=null) {
						ps.close();
					}
					if(ps1!=null) {
						ps1.close();
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
