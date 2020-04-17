package com.jay.java.DynamicCompiler;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * javassist
 * @author jay
 *
 */
public class TestJavaSist {
	public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
		//1. 获取pool
		ClassPool pool = ClassPool.getDefault();
		CtClass cc= pool.makeClass("com.jay.java.DynamicCompiler.Emp");
		
		//创建属性,
			//源码级别的操作
		CtField f1 = CtField.make("private int empno;",	 cc);
		CtField f2 = CtField.make("private String ename;", cc);
		cc.addField(f1);
		cc.addField(f2);
		
		CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}", cc);
		CtMethod m2 = CtMethod.make("public void setEmpo(int empno){ this.empno=empno;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		
		//构造器添加
		CtConstructor constuctor= new CtConstructor(new CtClass[]{CtClass.intType, pool.get("java.lang.String")},cc);
		constuctor.setBody("{this.empno = empno; this.ename =ename;}");
		
		cc.writeFile("com/jay/java/DynamicCompiler");
		System.out.println("成");
	}
}
