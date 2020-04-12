package com.jay.java.IO.TestFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 -IO流
 * 	- 流需要源头和目的地
 * 	- 数组，网络连接，数据库,文件 -》 程序
 * 	- 以程序为中心
 * - 输入流和输出流
 * - 字节流和字符流
 * 		- 字节流Byte ： 二进制，可以处理一切文件，包括纯文本， doc 音频，视频等
 * 		- 字符流Words	： 文本文件,纯文本 
 * - 功能：
 * 	- 离文件最近的是： 节点流，包裹源头的
 * 	- 处理流：增强功能提高性能的
 * -常用的
 * 	- 字符流和字节流<重点>
 * 	- 字节流：
 * 		- 输入流InputStream
 * 			- read(byte[]) + close read(byte[] int off int len) 
 * 			- FileInputStream
 * 		- 输出流 OutputStream，
 * 			- write(byte[] / int off, len
 * 			- flush
 * 			- close
 * 		- FileOutputStream
 * 	- 字符流
 * 		- 输入 reader: read(char[]) read(char[] int off int len)  close()
 * 		- FileReader		
 * 	- 输出 writer: write(char[] cbuf) flush() + close() write(String int off, int len)
 * 		-FileWrite
 * 
 * 操作:
 * 	- 关联	--- 建立文件
 * 	- 选择	--- 选择对应流
 * 	- 搬家	-- 读取或者写出
 * 		- 大小	--- 数组大小
 * 		- 运输	--- 读取或者写出
 * 	- 结束	---释放资源
 * 1. 建立联系
 * 2. 选择流
 * 3. 操作 数组大小， Read 。write
 * 4. 释放资源	close()
 * 
 * 
 * - 文件的拷贝
 * 	- 读取文件，
 * 	- 写文件，
 * @author jay
 *
 */
public class TestIOStream {
	public static void main(String[] args) {
	/*	TestReadFile();
		TestWriteFile();
		TestReadFile();*/
		/* try {
			TestCopy();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 CopyDir();
	}
	public static void TestReadFile() {
		//1. 建立联系，File对象
		File src = new File("/Users/chengpengjiang/Documents/coding/Java/java_study/StudyJava/ObjectOriented/a.txt");
		
		//2. 选择流 文件流类型，，InputStream FileInputStream
			//提升作用域
		InputStream is = null;
		try {
			//编译时异常，只要与外界进行联系
		//3. 操作 byte[] car = new byte[1024] + read+ 
			 is = new FileInputStream(src);
			 //缓冲数组，定义
			 byte[] car = new byte[10];
			 //定义实际读取的大小 
			 int len = 0;
			 //循环读取
			 	// len = -1 没有数据
			 while(-1!= (len=is.read(car))){
				 //字节数组转成字符串
				 String info = new String(car, 0 ,len);
				 System.out.println(info);
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件读取失败");
			
		}finally {
	//4. 回收资源
			
			try {
				if(null != is) {
				is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
	public static void TestWriteFile() {
		//1. 建立联系 File 对象， 目的地
		File dest = new File("/Users/chengpengjiang/Documents/coding/Java/java_study/StudyJava/ObjectOriented/a.txt");
		//fileOutputStream(File file, boolean append)	
		OutputStream os = null;
		
		try {
			os = new FileOutputStream(dest,true);
			String str = "thsi is  a good man";
			byte[] data = str.getBytes();
			os.write(data, 0 , data.length);
			
			os.flush();//强制刷新出去 如果没有就会驻留，  close方法会默认flush
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
		
			e.printStackTrace();
		}finally {
			try {
				if(null != os) {
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				//2. 选择流
		//3. 操作
		//4. 释放资源：关闭	
 
	}
	
	/**
	 * 文件的拷贝
	 * @throws IOException 
	 */
	public static void TestCopy(File src, File dest) throws IOException {
		TestCopy(src.getPath(),dest.getPath());
	}
	public static void TestCopy(String srcPath,String destPath) throws IOException {
		//1. 建立联系 File对象， 源头， 目的地
//		File src = new File("/Users/chengpengjiang/Documents/coding/Java/java_study/StudyJava/ObjectOriented/a.txt");
		File src = new File(srcPath);
			
		
		// 文件可以不存在
//		File dest = new File("/Users/chengpengjiang/Documents/coding/Java/java_study/StudyJava/ObjectOriented/b.txt");
		File dest = new File(destPath);
		if(dest.isDirectory()) {
			System.out.println("文件夹");
			return;
		}
		//2.选择流
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
		
		//3. 文件的拷贝
			//循环+读取+写出
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flush))) {
			//写出
			os.write(flush,0,len);
		}
		os.flush();
		
		//4.关闭
			//不可能为null
		os.close();
		is.close();
	}
	/**
	 * 文件夹的拷贝
	 * 1. 不能将父目录拷贝到子目录中
	 */
	
	public static void CopyDir() {
		String srcPath = "/Users/chengpengjiang/Documents/TestFileOper/temp";
		File src = new File(srcPath);
		String destPath = "/Users/chengpengjiang/Documents/TestFileOper/dest";
		File dest = new File(destPath);
		if(src.isDirectory()) {
				//如果是目录就替换
			dest = new File(destPath,src.getName());
			if(dest.getAbsolutePath().contains(src.getAbsolutePath())) {
				System.out.println("父目录不能拷贝到子目录里面");
				return;
			}
		}
		CopyDirDetails(src,dest);
		//1. 递归，查找子孙级别
		//2. 如果是文件直接复制
		//2.1 如果是文件夹就直接创建
		
	}
	public static void CopyDirDetails(File src,File dest) {
		if(src.isFile()) {
			//文件
			try {
				TestCopy(src,dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(src.isDirectory()) {
			dest.mkdir();
			//获取下一目录
			for(File sub : src.listFiles()) {
				CopyDirDetails(sub,new File(dest,sub.getName()));
			}
		}
	}
}