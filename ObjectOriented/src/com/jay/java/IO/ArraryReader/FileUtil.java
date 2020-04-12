package com.jay.java.IO.ArraryReader;

import java.io.Closeable;
import java.io.IOException;

/**
 * 写一个工具类来关闭流
 * @author jay
 *
 */
public class FileUtil {

	/**
	 * ...可变参数，只能在形参最后一个位置，处理方式和数组一致
	 */
	public static void close(Closeable ... io) {
		
		for(Closeable temp : io) {
			try {
				if(null != temp) {
					temp.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
public static <T extends Closeable>void closeAll(T ... io) {
		
		for(Closeable temp : io) {
			try {
				if(null != temp) {
					temp.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
