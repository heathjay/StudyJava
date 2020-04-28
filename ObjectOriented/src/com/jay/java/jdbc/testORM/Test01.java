package com.jay.java.jdbc.testORM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试使用object数组来封装一条数据
 * - 用Object数组封装一条信息
 * - 多条用list
 * @author jay
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			ps =conn.prepareStatement("select empname,salary,age from Emp where id>?");
			ps.setObject(1, 0);
			rs = ps.executeQuery();
			while(rs.next()) {
				Object[] obj = new Object[3];
				//System.out.println(rs.getString(1));
				obj[0] = rs.getString(1);
				obj[1]	= rs.getObject(2);
				obj[2] = rs.getObject(3);
				
				list.add(obj);
			}
			//链接关闭后仍然能保存信息
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
		for(Object[] objs : list) {
			
			System.out.println(""+objs[0] + "---"+ objs[1] + "----" + objs[2]);
		}
	}
}
