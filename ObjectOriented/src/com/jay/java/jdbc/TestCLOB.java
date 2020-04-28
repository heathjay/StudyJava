package com.jay.java.jdbc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 大文本对象测试
 * - ps.setClob(2, new FileReader(new File()))
 * - 字符串输入
 * 
 *  - 取出
 *  ps = conn.prepareStatement("select * from Emp where id=?");
				ps.setObject(1, 7014);
				
				rs = ps.executeQuery();
				while(rs.next()) {
					Clob c =rs.getClob("myInfo");
					Reader r = c.getCharacterStream();
					int temp = 0;
					while((temp=r.read())!=-1) {
						System.out.print((char)temp);
					}
				}
 * @author jay
 *
 */
public class TestCLOB {
	public static void main(String[] args) {
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestName","root","jiang888");
				/*
				//写入
				ps = conn.prepareStatement("insert into Emp(username,myInfo) values(?,?)");
				ps.setString(1,"jisjsi");
					//文件字节流
				//ps.setClob(2, new FileReader(new File("/Users/chengpengjiang/Documents/coding/Java/java_study/StudyJava/ObjectOriented/src/com/jay/java/jdbc/CLOB")));
					//字符串字节流
				//ps.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("jsijsijsiqhrbfb".getBytes()))));
				*/
				//取出
				
				ps = conn.prepareStatement("select * from Emp where id=?");
				ps.setObject(1, 7014);
				
				rs = ps.executeQuery();
				while(rs.next()) {
					Clob c =rs.getClob("myInfo");
					Reader r = c.getCharacterStream();
					int temp = 0;
					while((temp=r.read())!=-1) {
						System.out.print((char)temp);
					}
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(ps!=null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				if(conn!=null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
		
	}
}
