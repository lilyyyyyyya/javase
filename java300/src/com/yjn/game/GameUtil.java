package com.yjn.game;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;


//工具类
public class GameUtil {
	private GameUtil() {
		
	}
	/*
	 * 返回指定路径的图片对象
	 */
	public static Image getImage(String path) {
		BufferedImage bufferedImage=null;
		try {
			URL u=GameUtil.class.getClassLoader().getResource(path);
			bufferedImage=ImageIO.read(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bufferedImage;
	}
}
