package com.jay.java.jdbc.JORM.core;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jay.java.jdbc.JORM.bean.ColumnInfo;
import com.jay.java.jdbc.JORM.bean.TableBean;
import com.jay.java.jdbc.JORM.po.Emp;
import com.jay.java.jdbc.JORM.utils.JDBCUtils;
import com.jay.java.jdbc.JORM.utils.ReflectUtils;
import com.jay.java.jdbc.JORM.utils.StringUtils;
import com.jay.java.jdbc.JORM.vo.EmpVo;

/**
 * 负责mysql数据库的查询
 * @author jay
 *
 */
public class MySqlQuery implements Query{
	public static void testDML() {
		Emp e = new Emp();
		e.setId(1);
		e.setEmpname("11");
		e.setAge(181);
//		new MySqlQuery().delete(e);
		new MySqlQuery().update(e,new String[] {"empname","age"});
	}
	
	public static void testQuery() {
/*	List<Emp> list = new MySqlQuery().queryRows("select id,empname from emp where age>?", Emp.class, new Object[] {1});
		for(Emp e : list) {
			System.out.println(e.getEmpname());
		}
		*/
		String sql ="select e.id,e.empname,e.age,e.salary+e.bonus 'xinshui',d.dname 'deptName',d.address 'DeptAddr' from Emp e join dept d on e.deptId=d.id";
		List<EmpVo> list = new MySqlQuery().queryRows(sql, EmpVo.class,null);
		for(EmpVo e : list) {
			System.out.println(e.getEmpname()+ e.getDeptAddr() + e.getXinshui());
		}
	}
	public static void main(String[] args) {
		//Number 是Integer,Double等父类
		Object obj = new MySqlQuery().queryValue("select count(*) from Emp where salary>?", new Object[] {10});
		System.out.println((Number)obj);
		
	}

	@Override
	public int executeDML(String sql, Object[] params) {
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
	}

	@Override
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

	@Override
	public void delete(Class clazz, Object id) {
		//Emp.class,2 -->delete from emp where id = 2
		//通过class对象找TableBean
		TableBean tableInfo = TableContext.poClassTableMap.get(clazz);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
		String sql = "delete from " + tableInfo.getTname() + " where " + onlyPriKey.getName() + "=?";
		executeDML(sql,new Object[] {id});
	}

	@Override
	public void delete(Object obj) {
		Class c= obj.getClass();
		TableBean tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();//主键
		
		//通过反射机制调用属性对应的get方法或者set方法
		
		Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), obj);
		delete(c,priKeyValue);
	}

	@Override
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
	 * 库到对象
	 */
	@Override
	public List queryRows(String sql, Class clazz, Object[] params) {
		Connection conn = DBManager.getMysqlConn();
		List list =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		try {
			ps = conn.prepareStatement(sql);
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			//多行
			while(rs.next()) {
				if(list == null) {
					list = new ArrayList();
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, conn);
		}
		
		return list;
	}

	@Override
	public Object queryUniqueRows(String sql, Class clazz, Object[] params) {
		List list = queryRows(sql,clazz,params);
		return (list==null&&list.size()>0)? null:list.get(0);
	}

	@Override
	public Object queryValue(String sql, Object[] params) {
		Connection conn = DBManager.getMysqlConn();
		Object value =null;	//存储查询结果的独享
		PreparedStatement ps = null;
		ResultSet rs =null;
		try {
			ps = conn.prepareStatement(sql);
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			rs = ps.executeQuery();
			while(rs.next()) {
				//select count(*) from user
				value= rs.getObject(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, conn);
		}
		
		return value;
	}

	@Override
	public Number queryNumber(String sql, Object[] params) {
		return (Number)queryValue(sql,params);
	}

}
