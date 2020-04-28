package com.jay.java.jdbc.JORM2.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.jay.java.jdbc.JORM2.bean.Configuration;
import com.jay.java.jdbc.JORM2.pool.DBConnPool;

/**
 * 根据配置信息，维持链接
 * @author jay
 *
 */
public class DBManager {
	/**
	 * 配置信息
	 */
	private static Configuration conf;
	/**
	 * 连接池对象
	 * 如果是static 他会接初始化DBmanager
	 */
	private static DBConnPool pool;
	static {
		/**
		 * 加载指定的资源文件
		 */
		Properties pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/jay/java/jdbc/JORM/Test/db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conf = new Configuration();
		conf.setDriver(pros.getProperty("driver"));
		conf.setPoPackage(pros.getProperty("poPackage"));
		conf.setPwd(pros.getProperty("pwd"));
		conf.setUrl(pros.getProperty("url"));
		conf.setUser(pros.getProperty("user"));
		conf.setUsingDB(pros.getProperty("usingDB"));
		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setQueryClass(pros.getProperty("queryClass"));
		conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));
		conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));
		/**
		 * 加载一次表结构信息
		 */
		System.out.println(TableContext.class);
	}
	/**
	 * 获得链接的对象
	 * @return
	 */
	public static Connection getMysqlConn() {
		if(pool==null) {
			pool = new DBConnPool();
		}
		return pool.getConnection();
	}
	
	public static Connection createConn() {
		try {
			Class.forName(conf.getDriver());
			return DriverManager.getConnection(conf.getUrl(),conf.getUser(),conf.getPwd());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * 提供Configuration对象
	 * @return
	 */
	public static Configuration getConf() {
		return conf;
	}
	
	public static void close(ResultSet rs, Statement ps, Connection conn) {
		try {
			if(ps !=null) {
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//			if(conn != null) {
//				conn.close();
//			}
		pool.close(conn);
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 关闭链接的ps， conn
	 * @param ps
	 * @param conn
	 */
	public static void close(Statement ps, Connection conn) {
		try {
			if(ps !=null) {
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*if(conn != null) {
			conn.close();
		}*/
		pool.close(conn);
		
	}
	
	public static void close(Connection conn) {
		/*if(conn != null) {
			conn.close();
		}*/
		pool.close(conn);
		
	}
}
