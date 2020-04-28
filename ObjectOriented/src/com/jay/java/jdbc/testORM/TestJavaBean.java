package com.jay.java.jdbc.testORM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类对应表
 * - 属性对应列
 * @author jay
 *
 */
public class TestJavaBean {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		Emp emp = null;
		conn = JDBCUtil.getMysqlConn();
		List<Emp> list = new ArrayList<Emp>();
		try {
			ps =conn.prepareStatement("select empname,salary,age from Emp where id>?");
			ps.setObject(1, 0);
			rs = ps.executeQuery();
			while(rs.next()) {
				emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
				list.add(emp);
			}
			//链接关闭后仍然能保存信息
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		for(Emp e : list) {
			System.out.println(e.getEmpname() + "---" + e.getSalary() + "---" + e.getAge());
		}
	
	}
	
	public static void test01() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		Emp emp = null;
		conn = JDBCUtil.getMysqlConn();
		try {
			ps =conn.prepareStatement("select empname,salary,age from Emp where id=?");
			ps.setObject(1, 1);
			rs = ps.executeQuery();
			while(rs.next()) {
				emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));		
			}
			//链接关闭后仍然能保存信息
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
		System.out.println(emp.getEmpname() + "---" + emp.getSalary() + "---" + emp.getAge());
	}
	
}
