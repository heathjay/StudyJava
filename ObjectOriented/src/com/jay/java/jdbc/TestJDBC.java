package com.jay.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 测试跟数据库建立链接
 * 
 * //加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://host:port/database","user","pwd");
			
 *	Statement stm = conn.createStatement();
 *	- stm.execute(sql);//使用比较少，需要进行字符串拼接指令，name由外面给需要进行拼接
 *	- sql注入问题，会加入or 这些判断性语句
 *	PreparedStatement：继承Statement接口，由prepareStatement创建，
 *		- 用于发送含有一个或者多个输入参数的sql语句，
 *		- preparedStatement对象比Statement对象效率更高，方式SQL注入。一般都用 
 *		String sql = "insert into Emp(uname,pwd) values(?,?)";//占位符后set
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.set(1,"huquq");
			Date是sql.Date
			
			
 *	ResultSet集合:
 *		- 迭代器while(rs.next()){rs.getInt(cN);}
 *	- connection 需要关闭
 *	- preparedStatement关闭
 *	- Statement关闭
 *	- ResultSet关闭
 *@author jay
 *
 */
public class TestJDBC {
	public static void main(String[] args) {
		
	}
	public static void testPreparedstatement() {
		Connection conn =null;
		PreparedStatement pre =null;
		PreparedStatement ps =null;
		ResultSet set = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestName","root","jiang888");
			
			//preparedStatement-接口，厂商实现
				//预编译,占位符?
			String sql = "insert into Emp(username,pwd,regTime) values(?,?,?)";
			 pre = conn.prepareStatement(sql);
			//从1开始
			/*pre.setString(1, "zz");
			pre.setString(2, "18929839");*/
			pre.setObject(1, "ajis");
			pre.setObject(2, "hu");
			pre.setDate(3, new java.sql.Date(System.currentTimeMillis()));

			pre.execute();
			//pre.executeQuery()-查询，结果和对象返回
			//pre.executeUpdate()-返回更新行数
			
			/**
			 * 查询executeQuery()
			 */
			String sql2 = "select * from Emp where id>?";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, 2);
			
			set = ps.executeQuery();
			
			while(set.next()) {
				String temp = set.getInt(1) + "----"+set.getString(2);
				System.out.println(temp);
			}
			
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
				if(ps!=null) {
					ps.close();
				}
				if(pre!=null) {
					pre.close();
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
	/**
	 * 测试Statement
	 */
	public static void testStatement() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestName","root","jiang888");
		
			//Statement测试
			Statement stm = conn.createStatement();
			String name = "xx";
			String sql1 = "INSERT INTO Emp(username,pwd,regTime) VALUES('"+name + "',66666,NOW())";
			String sql = "INSERT INTO Emp(username,pwd,regTime) VALUES('张',66666,NOW())";
			stm.execute(sql);
			
			//sql注入
			String id = 2 + "";
				//String id = 5 + "or 1 = 1";
			String sql2 = "delete from Emp where id=" + id;
			stm.execute(sql2);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 测试加载驱动建立链接
	 */
	public static void testConn() {
		try {
			//1.加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//2.建立链接
				//包含一个socket链接,后期通过连接池进行管理
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestName","root","jiang888");
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
