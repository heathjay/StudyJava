package com.jay.java.TestTreeSet;

public class Worker implements java.lang.Comparable<Worker>{
	private String type;
	private double salary;
	public Worker(String type, double salary) {
		super();
		this.type = type;
		this.salary = salary;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public int compareTo(Worker o) {
	
		return this.salary > o.salary ? 1 : (this.salary == o.salary? 0: -1);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Worker [type=" + type + ", salary=" + salary + "]";
	}
	
	
}
