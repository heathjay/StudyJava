package com.jay.java.Pattern.State;
/**
 * 管理state对象
 * - 银行的账号
 * 	- 根据金额的不同可以做不同的切换
 * - 房间对象
 * 	- 房间的不同状态管理
 * 	- 切换状态，调用不同 状态下面的不同行为
 * @author jay
 *
 */
public class Context {
	private State state;

	public void setState(State state) {
		System.out.println("修改状态");
		this.state = state;
		state.handle();
	}
	
	
}
