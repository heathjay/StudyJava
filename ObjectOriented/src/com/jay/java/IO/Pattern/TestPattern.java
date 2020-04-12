package com.jay.java.IO.Pattern;
/**
 * 1. 音量扩音
 * 
 * 2. 类之间的关系
 * - 依赖：形参或者局部变量
 * - 关联：属性
 * 		- 聚合：属性， 整体与部分，不一致的声明周期人与手
 * 		- 组合：属性高，整体与部分，相同的声明周期 人和大脑
 * - 继承
 * - 实现：接口和实现类的关系
 * @author jay
 *
 */
public class TestPattern {
	public static void main(String[] args){
		Voice v = new Voice();
		v.say();
		Amplifier am = new Amplifier(v);
		am.say();
		
	}
}
