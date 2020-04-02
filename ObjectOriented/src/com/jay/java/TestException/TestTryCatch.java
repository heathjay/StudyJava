package com.jay.java.TestException;
import java.io.*;
/**
 * try,catch, finally
 * @author jay
 * try: 有可能出事,无异常跳过Catch，至少一个catch或者finally,局部变量有效，在finally无效,声明放在外面
 * catch: printStackTrace,异常捕获的顺序,可以捕获多个异常,子类应该放前面，父类放后面
 * finally:不管异常不异常都得执行,放关闭资源的代码
 * return : 执行顺序,try 内return； catch内return； finally内return：1. 执行try，catch语句给返回值赋值；2.finally可覆盖，一般不加return语句，
 * FileInputStream fis = new FileInputStream
 */
public class TestTryCatch {
	public static void main(String[] args) {
		//	声明放在外面
		FileReader reader = null;
		// * Convenience class for reading character files.
		
		try {
			reader = new FileReader("/Users/chengpengjiang/Documents/java_file_test/TestFile.java");
			char c = (char)reader.read();
			char c2 = (char)reader.read();
			System.out.println(""+c+c2);
			//catch 两个互换，子类应该放前面，父类放后面
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader != null) {
					reader.close();
				}			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
