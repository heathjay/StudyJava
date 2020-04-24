package com.jay.java.Pattern.Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人类:
 * 负责管理备忘录对象
 * - 如果保存多次，使用容器
 * @author jay
 *
 */
public class CareTaker {
	private EmpMemento mmt;
	
	private List<EmpMemento> list = new ArrayList<EmpMemento>();
	
	public EmpMemento getMmt() {
		return mmt;
	}

	public void setMmt(EmpMemento mmt) {
		this.mmt = mmt;
	}
	
}
