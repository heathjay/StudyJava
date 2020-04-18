package com.jay.java.DynamicCompiler;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

/**
 * 测试Javassist API
 * - 类信息
 * - 新增方法
 * 	- $0:this $1:actually +$2:parameter
 * 	- $args an array of parameters
 * 	- $$ 所有方法参数的简写，主要用在在方法的调用下 move(String a, String b ) move（$$）,相当于move($1,$2)
 * 	- $cflow 一个方法调用的深度
 * 	- $r方法返回值的类型
 * 	- $_ 方法的返回值
 * 	- addCatch 方法中加入try catch 块 $e 代表异常对象
 * 	- $class this的类型（Class） 也就是$0的类型
 * 	- $sig 方法参数的类型数组，数组的顺序是参数的
 * 	- CtNewMethod.make
 * 	- CtMethod method = new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType,CtClass.intType} , cc);
		method.setModifiers(Modifier.PUBLIC);
		method.setBody("{System.out.println(\"jisazncuah\");return $1+$2;}");
		cc.addMethod(method);
		
	
 * - 操作已经存在的方法，
 * - 操作属性 
 * 	- 	CtField f2 = CtField.make("private int empdd", cc);
		CtField f1 = new CtField(CtClass.intType, "salary",cc);
		f1.setModifiers(Modifier.PRIVATE);
		cc.addField(f1);
		
 * 		- 增加get/set方法
 * - 构造器
 * @author jay
 *
 */
public class TestJavAssistAPI {
	/**
	 * 处理类
	 * @param args
	 */
	public static void Test1(){
		ClassPool pool = ClassPool.getDefault();
		try {
			//获取已有的类
			CtClass cc = pool.get("com.jay.java.DynamicCompiler.Emp");
			
			byte[] bytes = cc.toBytecode();
			System.out.println(Arrays.toString(bytes));
			//包名+类名
			System.out.println(cc.getName());
			System.out.println(cc.getSimpleName());
			//父类接口信息
			System.out.println(cc.getSuperclass());
			System.out.println(cc.getInterfaces());
			
			
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotCompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试新的方法
	 * @param args
	 * @throws NotFoundException 
	 * @throws CannotCompileException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static void test2() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.jay.java.DynamicCompiler.Emp");
		//生成新的方法
		//CtMethod method = CtNewMethod.make("public int add(int a, int b){return a+b;}", cc);
			//新方法
		CtMethod method = new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType,CtClass.intType} , cc);
		method.setModifiers(Modifier.PUBLIC);
		method.setBody("{System.out.println(\"jisazncuah\");return $1+$2;}");
		cc.addMethod(method);
		
		//通过反射调用新生成的方法
		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();//调用无参构造，创建新的Emp对象
		

		Method m = clazz.getDeclaredMethod("add", int.class,int.class);
		Object  result = m.invoke(obj, 200,2000);
		
		System.out.println(result);
	}
	/**
	 * 操作已经存在的方法，
	 * - 插入语句
	 * 	- 获取类，
	 * 	- 获取CtMethod
	 * 	- m.insertBefore
	 * 	- m.insertAt 某一行前面加
	 * @throws NotFoundException
	 * @throws CannotCompileException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static void test03() throws NotFoundException, CannotCompileException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.jay.java.DynamicCompiler.Emp");
		
		CtMethod method = cc.getDeclaredMethod("sayHello",new CtClass[] {CtClass.intType});
		method.insertBefore("System.out.println($1); System.out.println(\"start\");");
		method.insertAfter("System.out.println(\"end\");");
		
		Class cz = cc.toClass();
		Object obj = cz.newInstance();
		Method m = cz.getDeclaredMethod("sayHello", int.class);
		Object result = m.invoke(obj, 300);
		System.out.println(result);
	}
	/**
	 * 属性的操作
	 * @throws NotFoundException
	 * @throws CannotCompileException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static void test04() throws NotFoundException, CannotCompileException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.jay.java.DynamicCompiler.Emp");
		
		CtField f2 = CtField.make("private int empdd", cc);
		CtField f1 = new CtField(CtClass.intType, "salary",cc);
		f1.setModifiers(Modifier.PRIVATE);
		cc.addField(f1);
		
//		cc.getDeclaredField("ename"); //获取指定的属性
		//增加相应的get/set方法
		cc.addMethod(CtNewMethod.getter("getSalary", f1));
		cc.addMethod(CtNewMethod.setter("setSalary", f1));
		
	}	
	
	public static void test05() throws NotFoundException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.jay.java.DynamicCompiler.Emp");

		CtConstructor[] cs = cc.getConstructors();
		for(CtConstructor temp:cs) {
			System.out.println(temp);
		}
	}
	
	public static void test06() throws NotFoundException, ClassNotFoundException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.jay.java.DynamicCompiler.Emp");
		
		Object[] allAnnotation = cc.getAnnotations();
		for(Object obj : allAnnotation) {
			System.out.println(((Author)obj).value());
		}
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NotFoundException, CannotCompileException, ClassNotFoundException {
		//Test1();
		//test2();
		//test03();
		 test05();
		 test06();
		 
	}
}
