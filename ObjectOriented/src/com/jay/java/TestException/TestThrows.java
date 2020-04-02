package com.jay.java.TestException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * throws
 * 谁调用，谁处理
 * @author jay
 *	子类声明的异常范围不能超过父类声明的范围：
 *		1. 没扔，
 *		2. 不能超范围 exception > IOException
 *3.父类没有声明异常，子类不能声明异常
 *4. 不可跑出原有方法泡壶异常类的父类或者上层类，‘
 *5/抛出异常乐境的树木不可以比原来的方法还多（并不指个货）
 *	手动抛出异常：throw ，没有s,可以直接new一个异常对抗出来
 */
public class TestThrows {
	String openFile() throws FileNotFoundException, IOException{
		FileReader reader = new FileReader("/Users/chengpengjiang/Documents/java_file_test/TestFile.java");
		char c = (char)reader.read();
		System.out.println(c);
		return "c";
	}
	
	public static void main(String[] args) {
		File f = new File("/Users/chengpengjiang/Documents/java_file_test/TestFile.java");
		if (!f.exists()) {
			try {
				throw new FileNotFoundException("File can not be found!");
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}
		}
	}
}
