package com.jay.java.Pattern.Builder;

import com.jay.java.Pattern.Builder.Modules.Engine;
import com.jay.java.Pattern.Builder.Modules.Escape;
import com.jay.java.Pattern.Builder.Modules.OribtalModule;

public class MyDirector implements Director{
	/**
	 * 调用构建者，构建子组件
	 */
	private AirshipBuilder builder;
	
	public MyDirector(AirshipBuilder builder) {
		super();
		this.builder = builder;
	}

	@Override
	public AirShip directorAirShip() {
		Engine e = builder.builderEngine();
		OribtalModule o = builder.builderOrbitalModule();
		Escape es = builder.builderEscape();
		
		/**
		 * 构建
		 */
		AirShip ship = new AirShip();
		ship.setEngine(e);
		ship.setEscapeTower(es);
		ship.setOrbitalModule(o);
		
		return ship;
	}

}
