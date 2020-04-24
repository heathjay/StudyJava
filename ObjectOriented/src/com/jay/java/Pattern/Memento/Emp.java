package com.jay.java.Pattern.Memento;
/**
 * 源发器类
 * @author jay
 *
 */
public class Emp {
	private String ename;
	private int age;
	private double salary;
	
	/**
	 * 备忘录操作
	 * @param ename
	 * @param age
	 * @param salary
	 */
	public EmpMemento memento() {
		return new EmpMemento(this);
	}
	/**
	 * 恢复对象
	 */
	public void recovery(EmpMemento mmt) {
		this.ename = mmt.getEname();
		this.age = mmt.getAge();
		this.salary = mmt.getSalary();
	}
	
	public Emp(String ename, int age, double salary) {
		super();
		this.ename = ename;
		this.age = age;
		this.salary = salary;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
