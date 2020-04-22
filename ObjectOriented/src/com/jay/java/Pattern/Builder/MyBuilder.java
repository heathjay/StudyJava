package com.jay.java.Pattern.Builder;

import com.jay.java.Pattern.Builder.Modules.Engine;
import com.jay.java.Pattern.Builder.Modules.Escape;
import com.jay.java.Pattern.Builder.Modules.OribtalModule;

public class MyBuilder implements AirshipBuilder{

	@Override
	public Engine builderEngine() {
		System.out.println("myEngine");
		/**
		 * - 单例模式 类.getInstance
		 * - 工厂模式 factory.creates(type)
		 */
		return new Engine("myEngine");	//可以通过工厂以及单例模式结合起来
	}

	@Override
	public OribtalModule builderOrbitalModule() {
		System.out.println("myOribital");
		return new OribtalModule("myOrbital");
	}

	@Override
	public Escape builderEscape() {
		System.out.println("myEscape");
		return new Escape("myEscape");
	}//Stringbuilder, DomBuilder
	

}
