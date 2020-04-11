package com.jay.java.CollectionQueueHashTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * hashTable 和HashMap的不同之处
 * - 父类不同，HashMap的父类是Map；HashTable的父类是dictionary
 * - HashMap 键值可以null，线程不安全，键值最多一个null，值可以多个null
 * - HashTable 同步，线程效率低下，键值不能为NUll
 * 
 * - Properties 继承Hashtable
 * 	- 作用：读写资源配置文件，
 * 	- 要求健与值只能为字符串
 * 	- setProperty
 * 	-	getProperty 有方法的重载，可以使用默认值
 * 	- 资源配置文件需要流
 * 	- 存储成后缀为.properties - store(OutputStream out, String comments)
 * 	- 存为.xml -storeToXML
 * 	- 相对路径和绝对路径
 * 	- 获取 load(Reader reader) / loadXML
 *  - 使用类相对路径读取配置文件，bin文件下面
 *  	类.class.getResourceAsStream("/")
 *  	Thread.currentThread().getContextClassLoader().getResourceAsStream()
 * @author jay
 *
 */
public class TestHashTable {
	//检查时异常
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		//key, value 只能为字符串
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "tiger");
		
		String url = pro.getProperty("url","test");
		System.out.println(url);
		//输出到文件绝对路径
		//pro.store(new FileOutputStream(new File("/Users/chengpengjiang/Documents/coding/Java/java_study/StudyJava/ObjectOriented/src/com/jay/java/CollectionQueueHashTable/db.properties")), "db配置");
		//pro.storeToXML(new FileOutputStream(new File("/Users/chengpengjiang/Documents/coding/Java/java_study/StudyJava/ObjectOriented/src/com/jay/java/CollectionQueueHashTable/db.xml")),"db");
		//可以在相对路径下
		pro.store(new FileOutputStream(new File("db.properties")), "xxx");
		
		Properties pro1 = new Properties();
		pro1.load(new FileReader("db.properties"));
		System.out.println(pro1.getProperty("user","xxxx"));
		
		Properties pro2 = new Properties();
		//l类相对路径 /bin
		//pro1.load(TestHashTable.class.getResourceAsStream("/com/jay/java/CollectionQueueHashTable/db.properties"));
		pro1.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(""));
		System.out.println(pro1.getProperty("user","xxxx"));
	}
}
