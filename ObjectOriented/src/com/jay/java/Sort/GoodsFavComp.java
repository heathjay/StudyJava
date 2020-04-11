package com.jay.java.Sort;
/**
 * 增加一个业务类
 * @author jay
 *
 */
public class GoodsFavComp implements java.util.Comparator<Good>{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Good o1, Good o2) {
		// TODO Auto-generated method stub
		return o1.getFav() - o2.getFav();
	}
	
}
