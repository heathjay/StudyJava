package com.jay.java.Pattern.Builder;

import com.jay.java.Pattern.Builder.Modules.*;

/**
 * 构建者模式
 * @author jay
 *
 */
public class AirShip {
	private OribtalModule orbitalModule;
	private Engine engine;
	private Escape escapeTower;
	
	public void launch() {
		System.out.println(this.engine.getName() + this.orbitalModule.getName() + this.escapeTower.getName());
	}
	
	public OribtalModule getOrbitalModule() {
		return orbitalModule;
	}
	public void setOrbitalModule(OribtalModule orbitalModule) {
		this.orbitalModule = orbitalModule;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Escape getEscapeTower() {
		return escapeTower;
	}
	public void setEscapeTower(Escape escapeTower) {
		this.escapeTower = escapeTower;
	}
	
	
}
