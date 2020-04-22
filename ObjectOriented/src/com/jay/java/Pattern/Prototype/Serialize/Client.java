package com.jay.java.Pattern.Prototype.Serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;


/**
 * 使用序列化和反序列化进行深克隆
 * @author jay
 *
 */
public class Client {
	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		
		Date d = new Date(12738L);
		Sheep s1 = new Sheep("jay",d);
		System.out.println(s1);
		System.out.println(s1.getBirthday());
		/**
		 * 序列化和反序列化实现
		 */
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		//序列化
		oos.writeObject(s1);
		byte[] bytes = bos.toByteArray();
		//反序列化
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Sheep s2 = (Sheep)ois.readObject();
		//s2反序列化能把所有属性都序列化
		d.setTime(1982938729L);
		System.out.println(s1.getBirthday());		
		System.out.println(s2);
		System.out.println(s2.getBirthday());
		System.out.println(s1.getSname().equals(s2.getSname()) );
		System.out.println(s1.getBirthday() == s2.getBirthday());
	}
}
