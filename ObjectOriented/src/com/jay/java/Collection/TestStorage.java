package com.jay.java.Collection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 一张表对应存储
 * 1. 对应类一条信息
 * @author jay
 *
 */
class Employees{
	private String name;
	private int id;
	private int salary;
	private String department;
	private Date hireDate;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the hireDate
	 */
	public Date getHireDate() {
		return hireDate;
	}
	/**
	 * @param hireDate the hireDate to set
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Employees(String name, int id, int salary, String department, String hireDate) throws ParseException {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.department = department;
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		
		this.hireDate = format.parse(hireDate);
	}

}
public class TestStorage {
	public static void main(String[] args) throws Exception {
		Employees e = new Employees("jj",11,111,"jsisji","2017-01-22");
		Employees e1 = new Employees("jssj",12,111,"jsisji","2012-01-22");
		Employees e2 = new Employees("j2j",13,111,"jsisji","2011-01-22");
		
		
		//三条目录放到一个collection里面
		List<Employees> list = new ArrayList<Employees>();
		list.add(e2);
		list.add(e1);
		list.add(e1);
		printEmpName(list);
	}
	
	public static void printEmpName(List<Employees> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
	}
	
}

