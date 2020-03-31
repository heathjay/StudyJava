package com.jay.encapsulation02.copy;

import com.jay.encapsulation01.Test01;

/**
 * 
 * @author jay
 * test protected - 子类可调用,即使不同包
 *
 */

public class TestProtected extends Test01{
	public void tt() {
		super.print();
		print();
	}
}
