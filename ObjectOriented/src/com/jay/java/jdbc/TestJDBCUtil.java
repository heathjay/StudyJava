package com.jay.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBCUtil {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = JDBCUtil.getMysqlConn();
		
		try {
			ps = conn.prepareStatement("insert into Emp (username) values(?)");
			ps.setString(1, "jijsis");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(ps,conn);
		}
		
		
	}
}
