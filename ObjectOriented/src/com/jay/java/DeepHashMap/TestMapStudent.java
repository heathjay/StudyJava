package com.jay.java.DeepHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 学生类
 * 面向对象+分拣存储
 * @author jay
 *
 */
public class TestMapStudent {
	public static void main(String[] args) {
		//1.
		List<Student> stu = exam();
		Map<String,Room> map = count(stu);
		view(map);
	}
	/**
	 * 查看总分和平均分，
	 * 遍历map
	 */
	
	public static void view(Map<String, Room> map) {
		Set<String> keys = map.keySet()	;
		Iterator<String> it = keys.iterator();

		while(it.hasNext()) {
			String no = it.next();
			Room room = map.get(no);
			double total = room.getTotal();
			double avg = total / room.getStuList().size();
			System.out.println(avg + "," + total);
		}
		
	}
	/**
	 * 统计分析
	 * 1. 面向对象，
	 * 2. 分拣存储
	 * @return
	 */
	public static Map<String, Room> count(List<Student> list){
		Map<String, Room> map = new HashMap<String, Room>();
			//1.遍历
		for(Student stu : list) {
			//分拣，查看是否存在该编号的班级，
			//如果不存在，增加班级
			String no = stu.getNo();
			double score = stu.getScore();
			Room room = map.get(no);
			if(null == room) {
				room = new Room(no);
				map.put(no, room);
			}
			//存在放入学生
			room.getStuList().add(stu);
			room.setTotal(room.getTotal() + score);
		}
		
		return map;
	}
	
	public static List<Student> exam(){
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("xzx","a",80));
		list.add(new Student("xax","a",80));
		list.add(new Student("xqx","a",80));
		
		list.add(new Student("xsx","b",80));
		list.add(new Student("xax","b",81));
		list.add(new Student("xzx","b",81));
		return list;
	}
}

class Student{
	private String name;
	private String no;
	private double score;
	
	
	public Student() {	
		
	}

	public Student(String name, String no, double score) {
		super();
		this.name = name;
		this.no = no;
		this.score = score;
	}

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
	 * @return the no
	 */
	public String getNo() {
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	}
	
}

class Room{
	private String no;
	private List<Student> stuList;
	private double total;
	
	public Room() {
		stuList = new ArrayList<Student>();
	}
	public Room(String no) {

		this();
		this.no = no;
	}
	public Room(String no, List<Student> stuList, double total) {
		super();
		this.no = no;
		this.stuList = stuList;
		this.total = total;
	}

	/**
	 * @return the no
	 */
	public String getNo() {
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * @return the stuList
	 */
	public List<Student> getStuList() {
		return stuList;
	}

	/**
	 * @param stuList the stuList to set
	 */
	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
