package com.jay.java.TestFile;

import java.io.File;
import java.io.IOException;

/**
 * 目录或者文件
 * java.io.File
 * @author jay
 *	separator
 *	isFile(),isDirectory,canRead, exists,isHidden
 *	createNewFile
 *	mkdirs,mkdir
 */
public class TestFile {
	public static void main(String[] args) {
		//目录
		File f = new File("/Users/chengpengjiang/Documents/java_file_test");
		//文件
		File f1 = new File("/Users/chengpengjiang/Documents/java_file_test/TestFile.java");
		//构造器,新建一个文件
		File f2 = new File(f,"Test.java");	
		File f3 = new File(f,"Test4.java");
		
		File f5 = new File("/Users/chengpengjiang/Documents/java_file_test/aa/cc/dd");
		f5.mkdirs();
		if(f3.exists()) {
			System.out.println("Test4 Has been created");
		}else {
			try {
				f3.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(f3.exists()) {
			f3.delete();
			System.out.println("Test4 Has been deleted");
		}
		
		if(f1.isFile()) {
			System.out.println("f1 is the file");
		}
		
		if(f.isDirectory()) {
			System.out.println("f is the directory");
		}
		if(f2.exists()) {
			System.out.println("f2 exists");
		}
		
	}
}
