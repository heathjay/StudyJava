package com.jay.java.IO.Pattern;
/**
 * 扩音器
 * @author jay
 *
 */
public class Amplifier {
	private Voice voice;

	public Amplifier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Amplifier(Voice voice) {
		super();
		this.voice = voice;
	}
	public void say() {
		System.out.println(voice.getVoice()*1000);
	}
}
