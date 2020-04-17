package com.jay.java.TestScriptJS;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.script.*;
/**
 * 获得脚本引擎的对象
 * @author jay
 *
 */
public class TestDemo {

	public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		
		//定义变量
		engine.put("msg", "hishi sa ihihxkjh");
		//js和java的交互
		String str = "var user = {name:'hishi',age:18,schools:'TUD'};";
		str += "print(user.name);";
		
		//执行脚本
		engine.eval(str);
		//js里面修改变量
		engine.eval("msg = 'jisji lako sjifhi	';");
		//msg可以被两者操作
		System.out.println(engine.get("msg"));
		
		
		//定义函数
		engine.eval("function add(a,b){var sum = a+ b; return sum;}");
		//执行js函数,
			//找到接口
		Invocable jsInvoke = (Invocable) engine;
			//调用函数
		Object result1 = jsInvoke.invokeFunction("add", new Object[] {12,11});
		System.out.println(result1);
		/*
		//js调用java包，使用java包中的java类
		String jsCode = "importPackage(java.util); var list = Arrays.asList([\"新技术\",\"jisisi\"]);";
		engine.eval(jsCode);
		List<String> list = (List<String>)engine.get("list");
		for(String temp : list) {
			System.out.println(temp);
		}
		*/
		
		//执行一个js文件，将js文件放在项目src下面
			//默认在classPath下找资源
		URL url = TestDemo.class.getClassLoader().getResource("com/jay/java/TestScriptJS/a.js");
		System.out.println(url);
		FileReader fr = new FileReader(url.getPath());
		engine.eval(fr);
		fr.close();
		
	}

}
