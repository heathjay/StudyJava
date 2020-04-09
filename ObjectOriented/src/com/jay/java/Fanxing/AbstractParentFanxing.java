package com.jay.java.Fanxing;
/**
 * 泛型父类
 * - 子类必须富二代
 * - 方法按需实现，重写方法类型按照父类指定
 * - 子类中使用父类的属性随父类而定
 * - 子类中自己的属性按照需要而定，
 * - 接口只有方法没有属性
 * - 保留下来给子类实现，
 * 	- 全部保留
 * 	- 部分保留
 * 
 * - 不保留，子类按需实现
 * 	- 具体类型
 * 	- 没有类型，擦除 = Object 蕾丝
 * 	- 不等同于Object 
 * 	- 自动装箱 int - Integer - Object // 使用时需要强制转换
 * @author jay
 *
 */
public abstract class AbstractParentFanxing<T1, T2> {
	T1 age;
	public abstract void test(T2 name);
}
//保留下来给子类实现，
//不保留


//部分保留
class C1<T1> extends AbstractParentFanxing<T1,String>{

	/* (non-Javadoc)
	 * @see com.jay.java.Fanxing.AbstractParentFanxing#test(java.lang.Object)
	 */
	@Override
	public void test(String name) {
		// TODO Auto-generated method stub
		//this.age --> T1
		
	}
	
}
//全部保留
class C2<T1,T2> extends AbstractParentFanxing<T1,T2>{

	/* (non-Javadoc)
	 * @see com.jay.java.Fanxing.AbstractParentFanxing#test(java.lang.Object)
	 */
	@Override
	public void test(T2 name) {
		// TODO Auto-generated method stub
		
	}
	
}
//不保留
//没有类型
class C3 extends AbstractParentFanxing{

	/* (non-Javadoc)
	 * @see com.jay.java.Fanxing.AbstractParentFanxing#test(java.lang.Object)
	 */
	@Override
	public void test(Object name) {
		// TODO Auto-generated method stub
		
	}
	//类似于Object
	
}
//按需实现
class C4 extends AbstractParentFanxing<String,Integer>{

	/* (non-Javadoc)
	 * @see com.jay.java.Fanxing.AbstractParentFanxing#test(java.lang.Object)
	 */
	@Override
	public void test(Integer name) {
		// TODO Auto-generated method stub
		
	}
	//类似于Object
	
}

class C5<A,B> extends AbstractParentFanxing<String,Integer>{

	/* (non-Javadoc)
	 * @see com.jay.java.Fanxing.AbstractParentFanxing#test(java.lang.Object)
	 */
	@Override
	public void test(Integer name) {
		// TODO Auto-generated method stub
		
	}
	//类似于Object
	
}