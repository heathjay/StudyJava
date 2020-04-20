
package com.jay.java.JVM;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 加密操作
 * @author jay
 *
 */
public class Encryption {
	
	public static void main(String[] args) {
		encrpt(new File("/Users/chengpengjiang/Documents/TestFileOper/HelloWorld.class"),new File("/Users/chengpengjiang/Documents/TestFileOper/dest/HelloWorld.class"));
	}
	public static void encrpt(File src, File dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
		
			int temp = -1;
			while(-1 != (temp=fis.read())) {
				fos.write(temp ^0xff);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void encrpt(String srcPath, String destPath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		File src = null;
		File dest = null;
		try {
			src = new File(srcPath);
			dest = new File(destPath);
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
		
			int temp = -1;
			while(-1 != (temp=fis.read())) {
				fos.write(temp ^0xff);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
	}
}
