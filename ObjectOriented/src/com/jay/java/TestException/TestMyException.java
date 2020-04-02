package com.jay.java.TestException;
/**
 * 自定义异常
 * exception或者他的子类
 * @author jay
 * lang包的exception
 * 
 * 使用建议：
 * 	避免使用异常处理代替错误处理，这样会降低程序的清晰性，效率低下
 * 处理异常不可以代替简单的测试，只在异常情况下使用异常机制
 * 不要进行小粒度的异常处理，应该将整个任务包装在一个Try语句中，带任务，不要一句话一个try
 * 异常往往在高层处理
 */
public class TestMyException extends Exception {
	public TestMyException() {
		
	}
	
	public TestMyException(String message) {
		super(message);
	}
}

class MyException{
	void test() throws TestMyException{
		
	}
	public static void main(String args[]) {
		try {
			new MyException().test();
		}catch(TestMyException e) {
			e.printStackTrace();
		}
	}
}
