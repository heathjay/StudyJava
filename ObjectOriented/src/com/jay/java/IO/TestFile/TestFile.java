package com.jay.java.IO.TestFile;
/**
 * file类
 * - 两个常用常量
 * 	- 路径分隔符; 实现跨平台 pathSeparator
 * 	- 文件分隔符 \ win / linux separator
 * - 构造器
 * 	- 绝对路径
 * 	- 相对路径
 * 
 * - 常用
 * 	-getName
 * 	- getPath
 * 	-getParent
 * 	- getAbsolutePath
 * 
 * 	- src.exists()
 * 	- .canWrite()
 * 	- .canRead()
 * 	-.isFile
 * 	- isDirectory
 *	- 创建删除  
 *	- createNewFile 如果文件存在会返回false
 *	- src.delete
 *	- File.createTempFile
 *	- 创建目录
 *		- mkdir 创建目录，必须保持父目录存在，如果不存在，则创建失败
 *		- mkdirs 创建目录，如果父目录不存在，一同创建，以层层进行创建
 *		- lsit()
 *		- listFiles（）
 * 
 * @author jay
 *
 */

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class TestFile {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		// 构造器
//		TestConstractor();
		//常用函数
		//判断
		//TestJudge();
/*		try {
			TestCreateDel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件操作失败");
		}*/
		
		/*String pwd = "/Users/chengpengjiang/Documents/master-dse";
		File src = new File(pwd);
//		TestMkdir();
		TestPrintDirAll(src);*/
		
	}
	/**
	 * 1.
	 */
	public static void TestConstant() {
		//实现跨平台
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		//路径的表达形式
		//1. 推荐
		String path = "/Users/chengpengjiang/Documents/coding/Java/java_study";
		//2. 可以实现跨平台，不是动态生成，也不推荐
		path = "Users" + File.separator;
	}
	/**
	 * 2. 构造器
	 */
	
	public static void TestConstractor() {
		String parentPath = "/Users/chengpengjiang/Documents/coding/Java/java_study";
		String name = "testA.txt";
		//相对路径
		File src = new File(parentPath, name);
		
		//不检查存在与否,只是建立一个练习
		src = new File(new File(parentPath), name);
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getParent());
		
		//绝对路径 File(String name)
		src = new File("/Users/chengpengjiang/Documents/coding/Java/java_study/testA.txt");
		//没有
		src = new File("test.txt");
		System.out.println(src.getPath());
		System.out.println(src.getParent());
		System.out.println(src.getAbsolutePath());
		
	}
	/**
	 * 3.常用方法
	 */
	public static void TestFunc() {
		File src = new File("/Users/chengpengjiang/Documents/coding/Java/java_study/StudyJava/ObjectOriented/a.txt");
		//getPath
		//getAbsolutePath /
		System.out.println(src.getPath());//如果src是绝对路径，返回绝对，否则相对路径
		System.out.println(src.getParent());	//如果是相对路径，没有上一级就是null
		System.out.println(src.getAbsolutePath());
		System.out.println(src.getName());
	}
	/**
	 * 4.判断信息
	 */
	
	public static void TestJudge() {
		File src = new File("a.txt");
		System.out.println("文件是否存在" + src.exists());
		//System.out.println(src.getAbsolutePath());
		//File 对象是文件和目录的抽象描述
		//判断是否可写可读
		System.out.println("文件是否可读:" + src.canRead());
		System.out.println("文件是否可写:" + src.canWrite());
		//System.out.println("文件是否可读:" + src.canRead());
		System.out.println("文件文件夹:" + src.isFile());
		//默认
		System.out.println("文件文件夹:" + src.isDirectory());
		//绝对路径是否
		System.out.println("路径:" + src.isAbsolute());
		//长度
		System.out.println("长度" + src.length());
		
	}
	
	/**
	 * 创建删除
	 * @throws IOException 
	 */

	public static void TestCreateDel() throws IOException {
		String path = "/Users/chengpengjiang/Documents/coding/Java/java_study/con";
		//不存在就创建
		File src = new File(path);
		if(!src.exists()) {
			//createNewFile 如果文件存在会返回false
			boolean flag = src.createNewFile();
			System.out.println(flag?"成功" : "失败");
		}
		
		if(src.isFile()) {
			System.out.println("文件");
		}else if(src.isDirectory()) {
			System.out.println("文件夹");
		}else {
			System.out.println("文件不存在");
			
		}
		
		//删除文件
		boolean flag = src.delete();
		System.out.println(flag?"成功" : "失败");
		
		//两个静态方法
		//创建临时文件，
		//前缀，后缀， 
		File temp = File.createTempFile("test", "temp", src);
		temp.deleteOnExit();
	}
	/**
	 * 创建文件夹
	 */
	

	public static void TestMkdir() {
		String pwd = "/Users/chengpengjiang/Documents/coding/Java/java_study/test";
		File src = new File(pwd);
		src.mkdir();
		pwd =  "/Users/chengpengjiang/Documents/coding/Java/java_study/";
		src = new File(pwd);
		if(src.isDirectory()) {
			String[] subName = src.list();
			for(String temp : subName) {
				System.out.println(temp);
			}
		}
		
		System.out.println("====子目录|文件File对象");
		File[] subFile = src.listFiles();
		for(File temp : subFile) {
			System.out.println(temp.getName());
		}
		System.out.println("====过滤器");
		subFile = src.listFiles(new FilenameFilter() {
			
			/**
			 * dir代表自己的src
			 */
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return new File(dir,name).isFile() && name.endsWith(".jar");
			}
			
		});
		
		for(File temp : subFile) {
			System.out.println(temp.getName());
		}
		
	}
	
	public static void TestPrintDirAll(File dir) {
		if (null == dir || !dir.exists()) {
			return;
		}
		System.out.println("-" + dir.getAbsolutePath());
		if(dir.isDirectory()) {
			File[] subFiles = dir.listFiles();
			for(File tem :subFiles) {
				System.out.print("");
				TestPrintDirAll(tem);
			}
		}
		
		
	}
}
