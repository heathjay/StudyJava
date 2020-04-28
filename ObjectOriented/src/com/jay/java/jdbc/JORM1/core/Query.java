package com.jay.java.jdbc.JORM1.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jay.java.jdbc.JORM1.bean.ColumnInfo;
import com.jay.java.jdbc.JORM1.bean.TableBean;
import com.jay.java.jdbc.JORM1.utils.JDBCUtils;
import com.jay.java.jdbc.JORM1.utils.ReflectUtils;

/**
 * Query接口，负责对外提供服务的核心类
 * - 通过回调去优化query查询
 * @author jay
 *
 */
@SuppressWarnings(value = { "all" })
public abstract class Query implements Cloneable{
	public Object executeQueryTemplate(String sql, Object[] params,Class clazz, CallBack back) {
		Connection conn = DBManager.getMysqlConn();
		List list =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		try {
			ps = conn.prepareStatement(sql);
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			return back.doExecute(conn, ps, rs);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			DBManager.close(ps,conn);
		}
	}
	/**
	 * 直接执行一个dml语句
	 * @param sql	语句
	 * @param params	参数
	 * @return 执行sql语句后影响了几行语句
	 */
	public int executeDML(String sql,Object[] params) {
		Connection conn = DBManager.getMysqlConn();
		int count = 0;
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			JDBCUtils.handleParams(ps, params);
			
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, conn);
		}
		return count;
	};
	
	/**
	 * 将一个对象存储到数据库中,
	 * 把对象中不为null的属性往数据库中存储
	 * @param obj
	 */
	public void insert(Object obj) {
		//把对象obj -> 表中 insert into 表明(id,uname,pwd) values(?,?,?);
		StringBuilder sql = new StringBuilder();
		sql.append("insert into ");
		//获取表名字
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>();
		TableBean tableInfo = TableContext.poClassTableMap.get(c);
		sql.append(tableInfo.getTname()+" (");
		int countNotNullField = 0;
		//获取属性
		Field[] fs = c.getDeclaredFields();
		for(Field f:fs) {
			String fieldName = f.getName();
			Object fieldValue = ReflectUtils.invokeGet(fieldName, obj);
			
			if(fieldValue != null) {
				countNotNullField++;
				sql.append(fieldName + ",");
				params.add(fieldValue);
			}
		}
		//参数
		
		sql.setCharAt(sql.length()-1, ')');
		sql.append("values (");
		for(int i = 0; i< countNotNullField;i++) {
			sql.append("?,");
		}
		sql.setCharAt(sql.length()-1, ')');
		executeDML(sql.toString(),params.toArray());
		
		
	}
	/**
	 * 删除clazz表示类对应的表中记录
	 * @param clazz	跟表对应的类的Class对象，
	 * @param id 主键值
	 */
	public void delete(Class clazz, Object id) {
		//Emp.class,2 -->delete from emp where id = 2
		//通过class对象找TableBean
		TableBean tableInfo = TableContext.poClassTableMap.get(clazz);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
		String sql = "delete from " + tableInfo.getTname() + " where " + onlyPriKey.getName() + "=?";
		executeDML(sql,new Object[] {id});
	}
	/**
	 * 删除对象在数据库中对应的记录，对象所在的类对应到表，对象的主键的值对应到记录
	 * @param obj
	 */
	public void delete(Object obj) {
		Class c= obj.getClass();
		TableBean tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();//主键
		
		//通过反射机制调用属性对应的get方法或者set方法
		
		Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), obj);
		delete(c,priKeyValue);
	}
	/**
	 * 跟新对象对应的记录，并且只更新指定的字段值
	 * @param obj	更新的对象
	 * @param fieldNames
	 * @return 影响了几行
	 */
	public int update(Object obj, String[] fieldNames) {
		//obj{"uname","pwd"} --> update 表明 set uname = ?, pwd=? where id = ?
		
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>();
		TableBean tableInfo = TableContext.poClassTableMap.get(c);
		StringBuilder sql = new StringBuilder("update "+ tableInfo.getTname() + " set ");
		
		for(String fname : fieldNames) {
			Object fvalue = ReflectUtils.invokeGet(fname, obj);
			params.add(fvalue);
			sql.append(fname + "=?,");
		}
		sql.setCharAt(sql.length()-1, ' ');
		sql.append(" where ");
		ColumnInfo priKey = tableInfo.getOnlyPriKey();
		sql.append(priKey.getName() + "=? ");
		params.add(ReflectUtils.invokeGet(priKey.getName(), obj));
		return executeDML(sql.toString(),params.toArray());
		
	}
	/**
	 * 查询返回多行记，并将没行记录封装到clazz指定的类对象中
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public List queryRows(final String sql, final Class clazz,final Object[] params) {
		
		
		return (List)executeQueryTemplate(sql,params,clazz,new CallBack() {	
		
			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				ResultSetMetaData metaData;
				 List list =null;
				//多行
				try {
					
					metaData = rs.getMetaData();
					while(rs.next()) {
						if(list == null) {
							list=new ArrayList();
						}
						Object rowObj = clazz.newInstance();//无参构造
						//多列 select username, pwd from user where id > ? and age >18
						for(int i =0; i < metaData.getColumnCount();i++) {
							String columnName = metaData.getColumnLabel(i+1);//将设username
							Object columnValue = rs.getObject(i+1);
							
							ReflectUtils.invokeSet(rowObj, columnName, columnValue);
						}
						list.add(rowObj);
					}
				} catch (InstantiationException | IllegalAccessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return list;
			}
		}
		);
	
	}

	/**
	 * 查询返回一行记录，并将没行记录封装到clazz指定的类对象中
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Object queryUniqueRows(String sql, Class clazz, Object[] params) {
		List list = queryRows(sql,clazz,params);
		return (list==null&&list.size()>0)? null:list.get(0);
	}

	/**
	 * 查询返回一行一列，并将该值返回
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Object queryValue(String sql, Object[] params) {
	
		
		return executeQueryTemplate(sql,params, null,new CallBack() {
			
			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				Object value =null;	//存储查询结果的独享
				try {
					while(rs.next()) {
						//select count(*) from user
						value= rs.getObject(1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return value;
			}
			
		});
	}

	/**
	 * 查询返回一行一列的数字，并将该值返回
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Number queryNumber(String sql, Object[] params) {
		return (Number)queryValue(sql,params);
	}	
	/**
	 * 分页查询
	 * @param pageNum 第几页
	 * @param size 每页显示多少
	 * @return
	 */
	public abstract Object queryPagenate(int pageNum,int size);
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
