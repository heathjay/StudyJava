package com.jay.java.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 测试
 * @author jay
 *
 */
public class GoodsApp {
	public static void main(String[] args) {
		List<Good> list = new ArrayList<Good>();
		list.add(new Good("good",100,2000));
		list.add(new Good("bad",50.10,2000));
		list.add(new Good("for",0,1000));
		System.out.println(list);
		//Collections.sort(list,new GoodPriceComp());
		//只需要改动业务类
		Collections.sort(list,new GoodsFavComp());
		System.out.println(list);
	}
}
