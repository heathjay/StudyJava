package com.jay.java.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
/**
 * 时间
 * @author jay
 *
 */
public class TestDate {
	/**
	 * 将字符串代表的日期转 yyyy-mm-dd hh:mm:ss
	 * @param dateStr
	 * @return
	 */
	public static long str2Date(String dateStr) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return format.parse(dateStr).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestName","root","jiang888");
				
				ps = conn.prepareStatement("select * from Emp where lastTime>? and lastTime <?");
				//ps = conn.prepareStatement("select * from Emp where lastTime <?");
				
				java.sql.Timestamp start = new java.sql.Timestamp(str2Date("2020-04-24 20:10:45")) ;
				java.sql.Timestamp end = new java.sql.Timestamp(str2Date("2020-04-24 20:20:45")) ;
				
				ps.setObject(1, start);
				ps.setObject(1, end);
				rs = ps.executeQuery();
		
				while(rs.next()) {
					System.out.println(rs.getInt("id") + "-----" + rs.getString("username"));
				}
				
			} catch (ClassNotFoundException | SQLException e) {
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
	
	public static void testInsertRandomTime() {
		Connection conn =null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet set = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestName","root","jiang888");
			//jdbc会自动提交，conn关闭的时候
			conn.setAutoCommit(false);
			
			for(int i = 0 ; i<1000;i++) {
				ps1 = conn.prepareStatement("insert into Emp(username,pwd,regTime,lastTime) values(?,?,?,?)");
				ps1.setObject(1, "iqhshsuiu" + i);
				ps1.setObject(2,"1278378");
				//插入随即日期，
				int rand = 100000000 + new Random().nextInt(1000000);
				
				//Timestamp stamp = new Timestamp(2015,1,29,8,15,20,12); 
				Timestamp stamp = new Timestamp(System.currentTimeMillis()-rand); //
				ps1.setObject(4, stamp);
				Date date = new Date(System.currentTimeMillis()+rand);
				ps1.setObject(3, date);
				ps1.execute();
			}
			
			
			
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
		} finally {
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
