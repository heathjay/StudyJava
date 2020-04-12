package com.jay.java.IO.ArraryReader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 1. 字节数组，节点流
 * 	- 输入流： ByteArrayInputStream, 构造方法byte[] buf + read() + close - 内存可以自动释放-两个java程序间
 * 	- 输出流 : ByteArrayOutputStream - 构造方法，缓冲区大小， + toByteArray()- 输出到自己数组里，不要使用多态
 * 	-数组的内容和长度有限，数据量有限
 * 
 * 	- 文件内容不用太大，
 * 		- 文件输入到字节数组里面
 * 			- InputStream is = new BufferedInputStream(
					new FileInputStream(src)
				);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
 * 		- 字节数组输出到文件
 * 			OutputStream os = new BufferedOutputStream(
				new FileOutputStream(dest)
				);
		
		//选择流，字节数组输入流
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		
 * 	- 处理流
 * 	- 基本类型+String 保留数据和类型
 * 		- 输入流： DataInputStream  - DataInput(Api	构造器(InputStream)
 * 				readXxx
 * 
 * 		- 输出流 	DataOutputStream writeXxx 基本数据类型加上字符串
 * 			保留了数据加类型所以乱码
 * 
 * - 引用类型， 保留对象的类型加上数据， 输入流反序列化， 输出流序列化，将我们的对象保存在文件里面或者自己数组里面
 * 		- 输入流： ObjectInputStream readObject()
 * 		- 输出流，序列化 ObjectOutputStream + writeObject（）
 * 		- 先序列化后反序列化，不是所有对象都可以反序列化，java.io.Serialable
 * 		- 不是所有属性高都需要序列化，不需要序列化的属性 transient透明
 * @author jay
 *
 */
public class TestByteArray {
	public static void main(String args[]) throws IOException, ClassNotFoundException {
/*		try {
			testByteArrayInputStream(TestByteArrayOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	
		/*byte[] data= getBytesFromFile("/Users/chengpengjiang/Documents/TestFileOper/temp/nn/Dockerfile");
		
		System.out.println(new String(data));*/
		
		
//		writeBaseTpye("/Users/chengpengjiang/Documents/TestFileOper/temp/nn/xx");
		//read("/Users/chengpengjiang/Documents/TestFileOper/temp/nn/xx");	
	/*	byte[] des = writeBaseTpyeToArray();
		System.out.println(des.length);
		readFormArray(des);*/
		
		//seri("/Users/chengpengjiang/Documents/TestFileOper/temp/nn/xx");
		reverseSeri("/Users/chengpengjiang/Documents/TestFileOper/temp/nn/xx");
		
	}
	/**
	 * 输入流
	 * @throws IOException
	 */
	public static void testByteArrayInputStream(byte[] src) throws IOException   {
		//读取字节数组，其他电脑上的内存
		//所有的传输都是流传输
	/*	String msg = "操作和jisjisji";
		byte[]	src = msg.getBytes();
		*/
		//选择流
		InputStream is = new BufferedInputStream(
				new ByteArrayInputStream(
						src)
				);
		//操作
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len=is.read(flush))) {
			System.out.println(new String(flush,0,len));
		}
		
		//释放资源
		is.close();
	}

	/*
	 * 字节输出流，有新增方法不能多态
	 */
	public static byte[] TestByteArrayOutputStream() throws IOException {
		//dest
		byte[] dest;
		//选择流
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		//传输的内容
		String msg = "sthisj alj owj owjei j";
		byte[]	info = msg.getBytes();
		//写到dest里面
		os.write(info, 0, info.length);
		//获取数据
		dest = os.toByteArray();
		//释放资源
		os.close();
		return dest;
	}
	
	/**
	 * 文件->数组->文件
	 * - 文件到数组
	 * 	- 文件输入流
	 * 	- 字节数组输出流
	 * - 字节数组--- 程序到文件
	 * 	- 字节数组输入流
	 * 	- 文件输出流
	 * @throws IOException 
	 */
	public static byte[] getBytesFromFile(String srcPath) throws IOException {
		//文件的源和目的器
		File src = new File(srcPath);
		byte[]	dest;
		//创建字节数组目的地
		InputStream is = new BufferedInputStream(
					new FileInputStream(src)
				);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))) {
			bos.write(flush,0,len);
		}
		bos.flush();
		//获取数据
		dest = bos.toByteArray();
		bos.close();
		is.close();
		return dest;
	}
	/**
	 * @throws IOException 
	 * 
	 */
	public static void toFileFromByte(byte[] src, String destPath) throws IOException {
		//创建源
		//目的地
		File dest = new File(destPath);
		OutputStream os = new BufferedOutputStream(
				new FileOutputStream(dest)
				);
		
		//选择流，字节数组输入流
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		
		//不断读取字节数组
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len= is.read(flush))) {
			//写入到文件
			os.write(flush,0,len);
		}
		os.flush();
		is.close();
	}

	/**
	 * 数据类型数据流
	 * - 输入流：
	 * 		- DataInputStream
	 * 		- DataOutputStream 
	 * @throws IOException 
	 */
	
	
	public static void writeBaseTpye(String destPath) throws IOException {
		double point = 2.5;
		long num = 100L;
		String str = "数据类型";
		
		//新增方法不能多态
		//关联
		File dest = new File(destPath);
		//选择流,新增方法不能多态
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
		
		//操作
		//写出的顺序和读取的顺序应该一样
		//保留了数据加类型所以乱码
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		
		dos.flush();
		dos.close();
	}
	/**
	 * DataInputStream 数据类型输入流
	 * @throws IOException 
	 */
	
	public static void read(String destPath) throws IOException {
		File src = new File(destPath);
		//选择流
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(new FileInputStream(src))
				);
		
		//操作
		//读取的顺序和写出的顺序一致，并且必须存在
		double num1 = dis.readDouble();
		long num2 = dis.readLong();
		String strc = dis.readUTF()	;
		dis.close();
		System.out.println(num1 + "+"+  num2 + "+" + strc);
	}
	
	/**
	 * DataInputStream 和字节数组之间的互动
	 * 不用进行解析
	 */
	public static byte[] writeBaseTpyeToArray() throws IOException {
		double point = 2.5;
		long num = 100L;
		String str = "数据类型";
		//目标数组
		byte[] dest = null;

		//选择流,新增方法不能多态
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						bos
						)
				);
		
		//操作
		//写出的顺序和读取的顺序应该一样
		//保留了数据加类型所以乱码
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		dos.flush();
		dest  = bos.toByteArray();
		dos.close();
		bos.close();
		return dest;
	}
	/**
	 * 从字节数组中读取类型和数据
	 * @throws IOException 
	 */
	public static void readFormArray(byte[] src) throws IOException {
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(src)
						)
				);
		
		double num1 = dis.readDouble();
		long num2 = dis.readLong();
		String strc = dis.readUTF()	;
		dis.close();
		System.out.println(num1 + "+"+  num2 + "+" + strc);
	}
	/**
	 * ObjectOutputStream序列化
	 * @param destPath
	 * @throws IOException
	 */
	public static void  seri(String destPath) throws  IOException {
		Employee emp = new Employee("jsijsi", 100000);
		
		File dest = new File(destPath);
		ObjectOutputStream dos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(dest))
				
				);
		dos.writeObject(emp);
		dos.flush();
		dos.close();
		
	}
	
	public static void reverseSeri(String destPath) throws FileNotFoundException, IOException, ClassNotFoundException {
		File dest = new File(destPath);
		ObjectInputStream dos = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(dest))
				);
		
		Object obj = dos.readObject();
		if(obj instanceof Employee) {
			Employee e = (Employee) obj;
			System.out.println(e.getSalary());
		}
	}
	
}
