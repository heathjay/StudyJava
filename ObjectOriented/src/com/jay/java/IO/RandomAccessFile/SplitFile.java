package com.jay.java.IO.RandomAccessFile;
/**
 * 思路
 * 	- 第一步： 进行分割的准备
 * 		- 块数
 * 		- 确定每一块的大小
 * 		- 每一块的名称
 * 	- 第二步
 * 		- 分割
 * 			- 第几块、每一块的起点、实际大小
 * 			- 文件的分割
 * - SequenceInputStream
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SplitFile {
	private String filePath;
	private String fileName;
	private long blockSize;
	private int size;
	private long length;
	private String destBlockPath;
	
	
	//每一块的名称
	private List<String> blockPath;

	public SplitFile() {
		this.blockPath = new ArrayList<String>();	
		
	}
	public SplitFile(String filePath,String destBlockPath) {
		this(filePath, 1024,destBlockPath);
	}
	public SplitFile(String filePath,long blockSize, String destBlockPath) {
		this();
		this.filePath = filePath;
		this.destBlockPath = destBlockPath;
		this.blockSize = blockSize;	
		init();
	}
	/**
	 * 初始化操作, 计算块数，确定文件名
	 */
	public void init() {
		File src= null;
		if(null == filePath || !(src=new File(filePath)).exists()){
			System.out.println(filePath + ":" );
			return;
		}
		if(src.isDirectory()) {
			System.out.println("dir");
			return;
		}

		this.fileName = src.getName();
		//计算块， 实际大小和每块大小
		this.length = src.length();
		if(this.blockSize > length) {
			this.blockSize = length;
			
		}
		//确定size
		size = (int)Math.ceil(length/this.blockSize);// 大于的最小正数	
		 initPathName();
		
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(long blockSize) {
		this.blockSize = blockSize;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<String> getBlockPath() {
		return blockPath;
	}
	public void setBlockPath(List<String> blockPath) {
		this.blockPath = blockPath;
	}
	private void initPathName() {
		for(int i = 0; i < this.size;i++) {
			this.blockPath.add(destBlockPath+ "/" +this.fileName+".part" + i);
		}
	}
	
/**
 * 文件分割
 * 	- 其实位置
 * 		- 文件大小
 * @param destPath分割文件的存放目录
 */
	public void split(String destPath) {
		
		long beginPos = 0;
		long actualBlockSize = blockSize;
		
		for(int i = 0 ;i < this.size;i++) {
			if(i == size -1) {
				actualBlockSize = this.length - beginPos;
			}
			splitDetail(i, beginPos,actualBlockSize);
			beginPos+=actualBlockSize;
		}
	}
	/**
	 * 文件的分割
	 * @param idx
	 * @param beginPos
	 * @param actualBlockSize
	 */
	public void splitDetail(int idx, long beginPos, long actualBlockSize) {
		//创建源
		File src = new File(this.filePath);
		File dest = new File(this.blockPath.get(idx));
		
		//选择流
		RandomAccessFile raf =null;
		BufferedOutputStream bos = null;
		try {
			raf= new RandomAccessFile(src,"r");
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			//读取文件
			raf.seek(beginPos);
			byte[] flush = new byte[1024];
			int len = 0;
			while(-1!=(len=raf.read(flush))) {
				
				if(actualBlockSize - len >=0) {
					bos.write(flush,0,len);
					actualBlockSize -=len;
				}else {
					bos.write(flush,0,(int)actualBlockSize);
					break;
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bos.close();
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
	public static void main(String[] args) {
/*		SplitFile file = new SplitFile( "/Users/chengpengjiang/Documents/TestFileOper/temp/nn/11.txt",1233,"/Users/chengpengjiang/Documents/TestFileOper/temp/nn/");
		System.out.println(file.getSize());
		file.split("/Users/chengpengjiang/Documents/TestFileOper/temp/nn/");*/
		
		
	}
	
	
	/**
	 * 文件的合并
	 * 多个流直接往里面写
	 */
	
	public void merge(String destPath) {
		File dest = new File(destPath);
		
		
		BufferedOutputStream bos = null;

	
		try {
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			BufferedInputStream bis = null;
			for(int i = 0; i < this.blockPath.size();i++) {
				bis = new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i))));
			
				byte[] flush = new byte[1024];
				int len = 0;
				while(-1 != (len=bis.read(flush))) {
					bos.write(flush,0,len);
				}
				bos.flush();
				bis.close();
			}
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void merge2(String destPath) {
		File dest = new File(destPath);
		
		
		BufferedOutputStream bos = null;
		//创建一个容器
		Vector<InputStream> v1 = new Vector<InputStream>();
		SequenceInputStream sis = null;
	
		for(int i = 0; i < this.blockPath.size();i++) {
			try {
				v1.add(new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i)))));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try {
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			sis = new SequenceInputStream(v1.elements());
			
				byte[] flush = new byte[1024];
				int len = 0;
				while(-1 != (len=sis.read(flush))) {
					bos.write(flush,0,len);
				}
				bos.flush();
				sis.close();
			
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
