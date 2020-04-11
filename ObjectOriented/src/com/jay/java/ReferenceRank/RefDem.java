package com.jay.java.ReferenceRank;

import java.lang.ref.WeakReference;

/**
 * 强引用
 * 软引用
 * 弱引用
 * 虚引用
 * @author jay
 *
 */
public class RefDem {

	public static void main(String[] args) {
		
		
	}
	
	public static void TestWeakReference() {
		//放在堆中,
				String str = new String( "ni hao quanshijie");
				//弱引用管理对象
				WeakReference<String> wr = new WeakReference<String>(str);
				System.out.println("gc运行前：" + wr.get());
				//断开引用
				str = null;
				System.gc();
				System.runFinalization();
				System.out.println("after gc:" + wr.get());
	}
	public static void TestStrongReference() {
				//强引用，字符串常量池
				String str = "ni hao quanshijie";
				//弱引用管理对象
				WeakReference<String> wr = new WeakReference<String>(str);
				System.out.println("gc运行前：" + wr.get());
				//断开引用
				str = null;
				System.gc();
				System.runFinalization();
				System.out.println("after gc:" + wr.get());
	}
}
