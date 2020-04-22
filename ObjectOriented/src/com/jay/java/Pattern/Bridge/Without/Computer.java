package com.jay.java.Pattern.Bridge.Without;
/**
 * 非常麻烦
 * @author jay
 *
 */
public interface Computer {
	void sale();
}


class Desktop implements Computer{

	@Override
	public void sale() {
		System.out.println("台式机");
	}
	
}
class Laptop implements Computer{

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("笔记本");
	}
}

class Pad implements Computer{
	@Override
	public void sale() {
		System.out.println("pad");
	}
}

class LenovoDesktop extends Desktop{
	@Override
	public void sale() {
		System.out.println("联想台式机");
	}
}

class LenovoLaptop extends Laptop{
	@Override
	public void sale() {
		System.out.println("联想笔记本");
	}
}
class LenovoPad extends Pad{
	@Override
	public void sale() {
		System.out.println("联想Pad");
	}
}

class DellDesktop extends Desktop{
	@Override
	public void sale() {
		System.out.println("Dell台式机");
	}
}

class DellLaptop extends Laptop{
	@Override
	public void sale() {
		System.out.println("Dell笔记本");
	}
}
class DellPad extends Pad{
	@Override
	public void sale() {
		System.out.println("Dell Pad");
	}
}