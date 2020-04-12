package com.jay.java.IO.OperStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * 处理流：
 * 	对其他流的处理，
 * - 字节流
 * 	- 字节缓冲流
 * 		- BufferedInputStream, OutputStream
 * 	- 一定要在节点流之上
 * - 字符流	
 * 	- BufferedReader, BufferedWriter
 * 	- ReadLine	newLine()-换行
 * 
 * - 转换流：
 * 	- 字节流转化为字符流， 处理编码集和解码
 * - 以程序为中心，
 * 	- 字符到二进制 编码： 编码字符集，文件进行操作，两者字符集不同，会出现乱码
 * 	- 二进制到字符 解码
 * - 乱码：
 * 	- 长度缺失
 * 	- 字符集不同
 * 
 * @author jay
 *
 */
public class TestOperPip {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String srcPath = "/Users/chengpengjiang/Documents/TestFileOper/temp/nn/Dockerfile";
		String destPath = "/Users/chengpengjiang/Documents/TestFileOper/temp/nn/xder";
		/*try {
			CopyFile(srcPath,destPath);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		}*/
		
		/*try {
			TestCopy(srcPath,destPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Test1();
		try {
			TestTransformRToIn(srcPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void TestBufferedByte() {
		
		
	}
	/**
	 * 字符缓冲流
	 * 	使用新增方法，不能使用多态
	 * @param srcPath
	 * @param destPath
	 * @throws IOException
	 */
	public static void CopyFile(String srcPath, String destPath) throws IOException {
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(src.isDirectory()) {
			System.out.println("it is a directory ");
			return;
		}
		if(dest.isDirectory()) {
			dest = new File(destPath,src.getName());
		}
		
		/*
		 * 新增方法不能使用多态
		 */
		/*Reader reader = null;
		Writer writer = null;*/
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			//套上字节缓冲流
			reader =new BufferedReader(new FileReader(src));
			writer = new BufferedWriter(new FileWriter(dest));
			
			//可以一行一行进行读取
			/*char[] flush = new char[1024];
			int len = 0;
			while(-1!=(len = reader.read(flush))) {
				writer.write(flush,0,len);
			}*/
			String line = null;
			while(null != (line = reader.readLine())) {
				writer.write(line);
				writer.newLine();//可以用writer.append("\n")
			}
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(null !=writer) {
				writer.close();
			}
			if(null!=reader) {
				reader.close();
			}
		}
		
	}
	
	/**
	 * 字节缓冲流
	 * 节点流上面加上缓冲流，没有新增方法
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	public static void TestCopy(File src, File dest) throws IOException {
		TestCopy(src.getPath(),dest.getPath());
	}
	
	public static void TestCopy(String srcPath,String destPath) throws IOException {
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(dest.isDirectory()) {
			System.out.println("文件夹");
			return;
		}
		//字节处理流直接加上 缓冲流提高性能
		//没有新增方法，加入缓冲流
		InputStream is =new BufferedInputStream( new FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flush))) {
			os.write(flush,0,len);
		}
		os.flush();
		
		os.close();
		is.close();
	}
	/**
	 * 字符流转换成字节流
	 * new String(byte[], charset )- 指定字符集进行解码
	 * @throws UnsupportedEncodingException 
	 *解码和编码的字符集不统一 
	 */
	public static void Test1() throws UnsupportedEncodingException {
		//解码
		String str = "中国"; // gdk
		//编码 char - > byte
		byte[]	 data = str.getBytes();
		//编码和解码的相统一
		System.out.println(new String(data));
		try {
			data = str.getBytes("utf-8");
			System.out.println(new String(data));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//编码
		byte[]	data2 = "中国".getBytes("utf-8");
		//解码
		str = new String(data2,"utf-8");
		//数据不完整
		System.out.println(new String(data2,0,3));	
	}
	
	/**
	 * 处理字符流转换成字节流处理乱码问题
	 * 原先需要知道编码的字符集
	 * 输出流：
	 * 	OutputStreamWriter- 编码
	 * 输入流
	 * 	InputStreamReader- 解码
	 * @throws IOException 
	 */
	
	public static void TestTransformRToIn(String srcPath) throws IOException {
		//字节流
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						//指定解码字符集
						new FileInputStream(new File(srcPath)), "UTF-8")
				);
		String info = null;
		while(null != (info = br.readLine())) {
			System.out.println(info);
		}
		
		br.close();
	}
	public static void TestTransformWToOn(String destPath) throws IOException {
		//字节流
		BufferedWriter wr = new BufferedWriter(
				new OutputStreamWriter(
						//指定解码字符集
						new FileOutputStream(new File(destPath)), "UTF-8")
				);
		String info = "thisifsjsjjssj";
		wr.write(info);
		wr.flush();
		wr.close();
		
	}
}
