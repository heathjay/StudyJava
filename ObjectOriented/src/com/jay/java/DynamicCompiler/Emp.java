package com.jay.java.DynamicCompiler;
@Author(value = "jay")
public class Emp {
	@Author(value="jj")
	private int empno;
	private String ename;
	public Emp(int empno, String ename) {
		super();
		this.empno = empno;
		this.ename = ename;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void sayHello(int a) {
		System.out.println("sayHello+"+a);
	}
}
