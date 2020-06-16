package com.yjn.io;

import java.io.File;

/**
 * 名称分隔符 separator
 * @author 82305
 *
 */
public class Test01 {
	public static void main(String[] args) {
		String path="C:/Users/82305/Desktop/java/learning/java300/gg.txt";//适合跨平台
		System.out.println(File.separator);
		//构建File对象
		File src=new File(path);
		System.out.println(src.length());
		//第二种
		src=new File("C:/Users/82305/Desktop/java/", "learning/java300/gg.txt");
		System.out.println(src.length());
		//第三种 父对象子名称
		src=new File(new File("C:/Users/82305/Desktop/java/"), "learning/java300/gg.txt");
		System.out.println(src.length());
	}
}
