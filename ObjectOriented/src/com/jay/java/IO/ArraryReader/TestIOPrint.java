package com.jay.java.IO.ArraryReader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * PrintStream 打印流
 * System
 * 	- in 输入流，键盘输入
 * - out 实质上和.err相同	
 * 	- err
 * -FileDescriptor.in
 * 
 * 
 * ===》重定向
 * 控制台转到文件
 * setIn 重新分配标准的输入流
 * SetOut 输出流
 * 
 * ====
 * 封装一个输入
 * 
 * @author jay
 *
 */
public class TestIOPrint {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("test");
		System.err.println("test");
		InputStream in = System.in;
		File src = new File("/Users/chengpengjiang/Documents/TestFileOper/temp/nn/xx");
		in = new BufferedInputStream(new FileInputStream(src));
		//文件作为输入
		Scanner scaner = new Scanner(in);
		PrintStream ps = System.out;
		ps.println("test");
		
		//输出到文件
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(src)));
		ps.println("is is oskoap ofjaoj fioj io");
		ps.flush();
	
		
		//重定向
		//printStream流设置true自动flush
		//打印日志
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(src)),true));
		System.out.println("shshshhs");
		//重定向回控制台
//		System.setOut(System.out);
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("shshshhs");
		ps.close();
		
		
		/**
		 * 封装一个Scanner
		 */
		InputStream is = System.in;
		//bufferedReader有新增方法
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println("请输入");
		String msg = br.readLine();
		System.out.println(msg);
		br.close();
	}
}
