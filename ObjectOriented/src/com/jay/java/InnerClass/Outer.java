package com.jay.java.InnerClass;
/**
 * 
 * @author jay
 * 内部类
 *	非静态内部类，即村子一个外部类对象里，外部类存在才存在
 *
 */
public class Outer {
	public static void main(String[] args) {
		Face f = new Face();
		Face.Nose n = f.new Nose();
		n.breath();
		Face.Ear e = new Face.Ear();
		e.listen();
	}
}

class Face{
	int type;
	String shape = "a";
	static String color = "ffff";
	class Nose{
		String type;
		void breath() {
			System.out.println("呼吸!");
			System.out.println(type);
			//命名有冲突
			System.out.println(Face.this.type);
			//命名无冲突
			System.out.println(shape);
		}
	}
	
	static class Ear{
		void listen() {
			System.out.println("he is listening");
			//System.out.println(shape);
			System.out.println(color);
		}
	}
}