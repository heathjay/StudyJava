package com.jay.java.jdbc.JORM1;

import java.util.List;

import com.jay.java.jdbc.JORM1.core.MySqlQuery;
import com.jay.java.jdbc.JORM1.core.Query;
import com.jay.java.jdbc.JORM1.core.QueryFactory;
import com.jay.java.jdbc.JORM1.vo.EmpVo;
/**
 * 测试连接池的调用效率
 * @author jay
 *
 */
public class Test2 {
	public static void test01() {

		Query q = QueryFactory.createQuery();
		String sql ="select e.id,e.empname,e.age,e.salary+e.bonus 'xinshui',d.dname 'deptName',d.address 'DeptAddr' from Emp e join dept d on e.deptId=d.id";
		List<EmpVo> list = q.queryRows(sql, EmpVo.class,null);
		for(EmpVo e : list) {
			System.out.println(e.getEmpname()+ e.getDeptAddr() + e.getXinshui());
		}
	}
	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		
		for(int i = 0 ;i < 3000;i++) {
			test01();
		}
		long b = System.currentTimeMillis();
		System.out.println(b-a);//不加连接池的耗时 20897
		//增加连接池后2795， 差不多10倍
	}
}
