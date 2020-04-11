package com.jay.jave.TestTreeSet;
/**
 * TreeSet
 * @author jay
 *
 */
public class Person {
	private final String name;
	private final int handsome;
	public Person() {
		this.name = null;
		this.handsome = 0;
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
//	public void setName(String name) {
//		this.name = name;
//	}
	/**
	 * @return the handsome
	 */
	public int getHandsome() {
		return handsome;
	}
	/**
	 * @param handsome the handsome to set
	 */
//	public void setHandsome(int handsome) {
//		this.handsome = handsome;
//	}
	public Person(String name, int handsome) {
		super();
		this.name = name;
		this.handsome = handsome;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", handsome=" + handsome + "]";
	}
	
	
}
