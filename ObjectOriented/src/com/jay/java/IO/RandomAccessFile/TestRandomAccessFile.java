package com.jay.java.IO.RandomAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 1. RandomAccessFile
 * 		- 任意地方开始读取
 * 
 * 2. 文件进行分割
 * 	- 分割的数量 size
 * 	- 分割的大小blockSize
 * 	最后一块的大小： 总的文件大小 - (n-1)*blockSize
 * 
 * 	
 * @author jay
 *
 */
public class TestRandomAccessFile {
	public static void main(String[] args) throws IOException {
		
		
	}

	public static void SplitFile() {
		
	}
	public static void TestRandom() throws IOException {
		String strPath = "/Users/chengpengjiang/Documents/TestFileOper/temp/nn/xxxxx";
		RandomAccessFile rm = new RandomAccessFile(new File(strPath),"r");
		rm.seek(10);// 默认是0，可以设置成10
		byte[] flush = new byte[1024];
		int len;
		while(-1!=(len=rm.read(flush))) {
			//每次读多少 
			//seek到下一块的开始
			if(len >= 200) {
				System.out.println(new String(flush,0,200));
				break;
			}else {
				System.out.println(new String(flush,0,len));
				
			}
			
		}
		rm.close();
	}
}
