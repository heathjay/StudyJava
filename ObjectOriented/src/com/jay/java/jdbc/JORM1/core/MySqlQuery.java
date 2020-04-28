package com.jay.java.jdbc.JORM1.core;

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

import com.jay.java.jdbc.JORM1.bean.ColumnInfo;
import com.jay.java.jdbc.JORM1.bean.TableBean;
import com.jay.java.jdbc.JORM1.utils.JDBCUtils;
import com.jay.java.jdbc.JORM1.utils.ReflectUtils;
import com.jay.java.jdbc.JORM1.utils.StringUtils;
import com.jay.java.jdbc.JORM1.vo.EmpVo;

/**
 * 负责mysql数据库的查询
 * 优化：
 * - template和hook模式应用，
 * - 分页问题mysql不同
 * @author jay
 *
 */
public class MySqlQuery extends Query{
	/*public static void testDML() {
		Emp e = new Emp();
		e.setId(1);
		e.setEmpname("11");
		e.setAge(181);
//		new MySqlQuery().delete(e);
		new MySqlQuery().update(e,new String[] {"empname","age"});
	}*/
	
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
///		testQuery();
		
	}

	@Override
	public Object queryPagenate(int pageNum, int size) {
		// TODO Auto-generated method stub
		return null;
	}



}
