package com.jay.java.Thread.Lock;
/**
 * 单例设计模式：
 * - 确保一个类只有一个对象，
 * - 外部不能创建对象
 * - jvm, gc - 内部自己创建
 * - 构造器私有化
 * - 声明一个静态变量，私有的对象实例
 * - 提供静态方法，让外部访问
 * 
 * --- 在单线程里面，只会生成一个对象
 * --- 多线程可能会生成多个对象，加入synchronized会解决
 * 		- 锁住模板： 类.class
 * 		- 锁住方法： 
 * -- 双重检查，提早检查synchronized
 * 
 * 
 * --- 2. 单例创建的几种方式
 * 		---- 2.1 懒汉
 * 				-- 双重检查
 * 				-- 构造器私有化
 * 				-- 声明私有的属性
 * 				-- 对外提供访问属性的静态方法，并确保对象存在
 * 		----2.2 饿汉
 * 			-- 构造器私有化
 * 			-- 声明私有化属性并且同时创建对象
 * 			--对外提供方法
 * public class Runtime {
    private static Runtime currentRuntime = new Runtime();
     public static Runtime getRuntime() {
        return currentRuntime;
    }
」
 * @author jay
 *
 */
public class TestSyn {
	public static void main(String[] args) {
		/*Jvm jvm1 = Jvm.getInstance();
		Jvm jvm2 = Jvm.getInstance();
		//单线程 jvm1 = jvm2
		System.out.println(jvm1);
		System.out.println(jvm2);*/
		
		JvmThread thread1 = new JvmThread(100);
		JvmThread thread2 = new JvmThread(500);

		thread1.start();
		thread2.start();
		System.out.println(thread1);
		System.out.println(thread2);
		
	}
}
/**
 * 一个类一个对象
 * 懒汉
 * - 私有化构造方法
 * - 静态私有的变量
 * - 创建一个对外的公共的静态方法，访问该变量，如果变量没有对象，创建该对象
 * 
 * @author jay
 *
 */
/*class Jvm{
	
	private static Jvm instance = null;// 懒汉，懒得创建对象，使用的时候创建
	
	//构造器私有化,避免外部直接创建对象
	private Jvm() {}
	
	//公共方法访问变量
	public static Jvm getInstance() {
		if(null == instance) {
			instance = new Jvm();
		}
		return instance;
	}
}*/
/**
 *创建一个线程个对他访问
 */
class JvmThread extends Thread{
	private long time;
	public JvmThread(long time) {

	}
	public JvmThread() {
		super();
		this.time = time;
	}
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + ":" + Jvm.getInstance(time));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class Jvm{
	
	private static Jvm instance = null;// 懒汉，懒得创建对象，使用的时候创建
	
	//构造器私有化,避免外部直接创建对象
	private Jvm() {}
	
	/*//公共方法访问变量
	public static synchronized Jvm getInstance(long time) throws InterruptedException {
		if(null == instance) {
			Thread.sleep(time);
			instance = new Jvm();
		}
		return instance;
	}*/
	/*//需要等待，效率低
	public static Jvm getInstance(long time) throws InterruptedException {
		synchronized(Jvm.class) {
			if(null == instance) {
				Thread.sleep(time);
				instance = new Jvm();
			}
			return instance;
		}
	}
		*/
	
	public static Jvm getInstance(long time) throws InterruptedException {
		//解决ab 存在对象也需要等待， 提高已经有对象的访问效率
		if(null == instance) {
			synchronized(Jvm.class) {
				if(null == instance) {
					Thread.sleep(time);
					instance = new Jvm();
				}
				return instance;
			}
		}
		return instance;
	}
}
	/**
	 * 懒汉构造方法
	 */
class MyJvm{
	private static MyJvm instance;
	private MyJvm() {
		
	}
	
	public static MyJvm getInstance() {
		if(null == instance) {
			synchronized(MyJvm.class) {
				if(null == instance) {
					instance = new MyJvm();
				}
			}
		}
		return instance;
	}
}

/**
 * 类在使用的时候加载。如果不调用JVMModel就不会调用，延缓加载时间
 * 提高效率构造方法
 */
class MyJvm3{
	private static class JVMModel{
		private static MyJvm3 instance = new MyJvm3();
	}
	
	private MyJvm3() {
		
	}
	public static MyJvm3 getInstance() {
		return JVMModel.instance;
	}
}
/**
 * 饿汉
 * 如果不使用那个getInstance方法，属性仍然可能被加载
 * @author jay
 *
 */
class MyJvm2{
	private static MyJvm2 instance = new MyJvm2();
	private MyJvm2() {
		
	}
	public static MyJvm2 getInstance() {
		return instance;
	}
}