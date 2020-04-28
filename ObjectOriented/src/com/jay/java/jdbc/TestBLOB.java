package com.jay.java.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试BLOB对象，二进制
 * ps = conn.prepareStatement("insert into Emp (username,heading) values(?,?)");
				ps.setString(1, "jay");
				ps.setBlob(2, new FileInputStream(new File("/Users/chengpengjiang/Documents/coding/Java/java_study/StudyJava/ObjectOriented/src/images/oval.png")));
				ps.executeUpdate();
 * 
 * @author jay
 *
 */
public class TestBLOB {
	public static void main(String[] args) {
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestName","root","jiang888");
				
				//存入
				/*ps = conn.prepareStatement("insert into Emp (username,heading) values(?,?)");
				ps.setString(1, "jay");
				ps.setBlob(2, new FileInputStream(new File("/Users/chengpengjiang/Documents/coding/Java/java_study/StudyJava/ObjectOriented/src/images/oval.png")));
				ps.executeUpdate();*/
				
				//取出
				ps = conn.prepareStatement("select * from Emp where id=?");
				ps.setObject(1, 7015);
				rs = ps.executeQuery();
				while(rs.next()) {
					Blob b = rs.getBlob("heading");
					InputStream is = b.getBinaryStream();
					OutputStream os = new FileOutputStream("/Users/chengpengjiang/Documents/coding/Java/java_study/StudyJava/ObjectOriented/src/com/jay/java/jdbc/a.jpg");
					
					int temp = 0;
					while((temp=is.read())!=-1) {
						os.write(temp);
					}
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
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
