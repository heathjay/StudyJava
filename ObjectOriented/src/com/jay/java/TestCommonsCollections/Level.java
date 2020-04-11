package com.jay.java.TestCommonsCollections;
/**
 * 等级类
 * @author jay
 *
 */
public class Level {
	private String name;
	private String level;
	public Level() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Level(String name, String level) {
		super();
		this.name = name;
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Level [name=" + name + ", level=" + level + "]";
	}
	
	
}
