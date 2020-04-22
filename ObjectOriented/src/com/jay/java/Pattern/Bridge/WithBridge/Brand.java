package com.jay.java.Pattern.Bridge.WithBridge;
/**
 * 品牌接口
 * @author jay
 *
 */
public interface Brand {
	void sale();
}


class Lenovo implements Brand{

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("联想品牌");
	}
	
}


class Dell implements Brand{
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("dell品牌");
		
	}
	
}