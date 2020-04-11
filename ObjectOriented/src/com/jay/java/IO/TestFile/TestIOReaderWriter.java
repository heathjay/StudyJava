package com.jay.java.IO.TestFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 字符流
 * - 只能处理纯文本文件,可以用txt打开，全部是可见字符
 * - 文件的读取
 * 	- 1. 建立联系
 * 	- 2。 选择类流
 * 	- 3. 操作 char[] bytes = new char[1024];
 * 			reader = new FileReader(src);
			
			char[]	flush = new char[10];
			int len = 0;
			while(-1!=(len = reader.read(flush))) {
				String str = new String(flush,0,len);
				System.out.println(str);
			}
 * - 文件的写入
 * 	- 1. 建立联系
 * 	- 2. 选择流
 * 	- 操作
 * 			//追加文件
			wr = new FileWriter(dest,true);
			String msg = "jaijidjsijhifhsifha fwij isffi 将	";
			wr.write(msg);
			wr.append("jsisjis");
			wr.flush();
 * - 文件的写出
 * @author jay
 *
 */
public class TestIOReaderWriter {
	public static void main(String args[]) {
		//TestWrite();
		//TestReader();
		String srcPath = "/Users/chengpengjiang/Documents/TestFileOper/temp/nn/Dockerfile";
		String destPath = "/Users/chengpengjiang/Documents/TestFileOper/temp/nn/xxxxx";
		try {
			CopyFile(srcPath,destPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 文件读取
	 */
	
	public static void TestReader() {
		File src = new File("/Users/chengpengjiang/Documents/TestFileOper/temp/nn/Dockerfile");
		if(src.isDirectory()) {
			System.out.println("it is a directory");
			return;
		}
		Reader reader = null;
		
		try {
			reader = new FileReader(src);
			
			char[]	flush = new char[10];
			int len = 0;
			while(-1!=(len = reader.read(flush))) {
				String str = new String(flush,0,len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(null != reader) {
						reader.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
	
	public static void TestWrite() {
		//1.建立关联
		File dest = new File("/Users/chengpengjiang/Documents/TestFileOper/temp/nn/xx");
		//2.选择流
		Writer wr = null;
		
		try {
			//追加文件
			wr = new FileWriter(dest,true);
			String msg = "jaijidjsijhifhsifha fwij isffi 将	";
			wr.write(msg);
			wr.append("jsisjis");
			wr.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	/**
	 * 拷贝文件
	 * 不能用于拷贝文件夹
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
		
		Reader reader = null;
		Writer writer = null;
		try {
			reader = new FileReader(src);
			writer = new FileWriter(dest);
			char[] flush = new char[1024];
			int len = 0;
			while(-1!=(len = reader.read(flush))) {
				
				writer.write(flush,0,len);
			}
			writer.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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
}
