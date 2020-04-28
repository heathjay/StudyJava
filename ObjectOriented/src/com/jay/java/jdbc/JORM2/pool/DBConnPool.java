package com.jay.java.jdbc.JORM2.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jay.java.jdbc.JORM2.core.DBManager;

/**
 * 连接池的类
 * @author jay
 *
 */
public class DBConnPool {
	/**
	 * 连接池对象
	 */
	private List<Connection> pool;
	/**
	 * 最链接数
	 */
	private static final int POOL_MAX_SIZE = DBManager.getConf().getPoolMaxSize();
	/**
	 * 最小连接数
	 */
	private static final int POOL_MIN_SIZE = DBManager.getConf().getPoolMinSize();

	/**
	 * 初始化连接池
	 */
	public void initPool() {
		if(pool == null) {
			pool = new ArrayList<Connection>();
		}
		
		while(pool.size() < DBConnPool.POOL_MIN_SIZE) {
			pool.add(DBManager.createConn());
			System.out.println("pool中的数量:" + pool.size());
		}
	}
	/**
	 * 从连接池中取出一个链接，通常是连接池中最后一个
	 * @return
	 */
	public synchronized Connection getConnection() {
		int last_index = pool.size() -1;
		Connection conn = pool.get(last_index);
		pool.remove(last_index);
		return conn;
	}
	/**
	 * 链接放回连接池中
	 * @param conn
	 */
	public synchronized void close(Connection conn) {
		if(pool.size() >=POOL_MAX_SIZE) {
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			pool.add(conn);
		}
		
	}
	
	public DBConnPool() {
		initPool();
	}
	
	
}
