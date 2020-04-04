package com.jay.java.MyProjectSun;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 常用工具类比如加载图片等方法
 *
 * @author jay
 *	
 */
public class GameUtil {
	
	private GameUtil() {
		
	}
	public static Image getImage(String path) {
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage imag = null;
		try {
			imag = ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imag;
	}
}
