package com.jay.java.TestFile;

import java.io.File;

/**
 * 展示文件夹的树状结构
 * 
 * @author jay
 *
 */
public class TestShowDirs {
	public static void printFile(File file, int level) {
		for(int i = 0;i < level; i++) {
			System.out.print("-");
		}
		System.out.println(file.getName());
		if(file.isDirectory()) {
			File[] files1 = file.listFiles();
			
			for(File temp : files1) {
				printFile(temp, level+1);
			}
		}
	}
	public static void main(String[] args) {
		File f = new File("/Users/chengpengjiang/Documents/java_file_test/");

		printFile(f,0);
	}
}
