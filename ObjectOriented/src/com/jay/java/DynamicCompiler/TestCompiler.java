package com.jay.java.DynamicCompiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * compiler.run(给编译器提供参数，得到编译器的输出信息，接受编译器的错误信息，可变参数)
 * - 返回0成功，非0失败
 * 
 * @author jay
 *
 */
public class TestCompiler {
	public static void main(String[] args) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, "/Users/chengpengjiang/Documents/TestFileOper/HelloWorld.java");
		System.out.println(result==0?"编译成功":"fail");
		
		
		//字符串
			//存成临时文件进行编译
		String str="public class Hi{ public static void main(String[] args) {System.out.println(\"xxx\")}}";
	}
}
