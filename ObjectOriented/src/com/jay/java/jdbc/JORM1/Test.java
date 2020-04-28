package com.jay.java.jdbc.JORM1;

import java.util.List;

import com.jay.java.jdbc.JORM1.core.MySqlQuery;
import com.jay.java.jdbc.JORM1.core.Query;
import com.jay.java.jdbc.JORM1.core.QueryFactory;
import com.jay.java.jdbc.JORM1.vo.EmpVo;

public class Test {
	public static void main(String[] args) {
		Query q = QueryFactory.createQuery();
		String sql ="select e.id,e.empname,e.age,e.salary+e.bonus 'xinshui',d.dname 'deptName',d.address 'DeptAddr' from Emp e join dept d on e.deptId=d.id";
		List<EmpVo> list = q.queryRows(sql, EmpVo.class,null);
		for(EmpVo e : list) {
			System.out.println(e.getEmpname()+ e.getDeptAddr() + e.getXinshui());
		}
	}
}
