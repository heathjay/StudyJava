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
 * 1. 使用map封装记录
 * 2. 使用List<Map>储存多条记录
 * 3. 使用Map<Map>再套一个map
 * @author jay
 *
 */
public class TestMapStore {
	public static void test01() {
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,Object> row = new HashMap<String,Object>();//使用一个map封装一条记录
		try {
			ps =conn.prepareStatement("select empname,salary,age from Emp where id>?");
			ps.setObject(1, 0);
			rs = ps.executeQuery();
			while(rs.next()) {
				row.put("empname", rs.getObject(1));
				row.put("salary", rs.getObject(2));
				row.put("age", rs.getObject(3));
				
			}
			//链接关闭后仍然能保存信息
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
		for(String key : row.keySet()) {
			System.out.print(key + "--" + row.get(key)+"\t");
		}
	}
	public static void test02() {
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			ps =conn.prepareStatement("select empname,salary,age from Emp where id>?");
			ps.setObject(1, 0);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> row = new HashMap<String,Object>();
				row.put("empname", rs.getObject(1));
				row.put("salary", rs.getObject(2));
				row.put("age", rs.getObject(3));
				list.add(row);
				
			}
			//链接关闭后仍然能保存信息
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		for(Map<String,Object> row :list) {
			for(String key : row.keySet()) {
				System.out.print(key + "--" + row.get(key)+"\t");
			}
			System.out.println();
		}
		
	}
	
	public static void test03() {
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, Map<String,Object>> map = new HashMap<String,Map<String,Object>>();
		
		try {
			ps =conn.prepareStatement("select empname,salary,age from Emp where id>?");
			ps.setObject(1, 0);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> row = new HashMap<String,Object>();
				row.put("empname", rs.getObject(1));
				row.put("salary", rs.getObject(2));
				row.put("age", rs.getObject(3));
				map.put((String) rs.getObject(1), row);
				
			}
			//链接关闭后仍然能保存信息
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		for(String empname: map.keySet()) {
			
			for(String key : map.get(empname).keySet()) {
				System.out.print(key + "--" + map.get(empname).get(key)+"\t");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
	}

}
