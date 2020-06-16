package com.yjn.io;

import java.io.File;

public class Test02 {
	public static void main(String[] args) {
		File src=new File("C:/Users/82305/Desktop/java/learning/java300/gg.txt");
		
		System.out.println("名称："+src.getName());
		System.out.println("路径："+src.getPath());
		System.out.println("绝对路径："+src.getAbsolutePath());
		System.out.println("父路径："+src.getParent());
		
		src=new File("gg.txt");
		System.out.println("名称："+src.getName());
		System.out.println("路径："+src.getPath());//根据path返回绝对路径或相对路径
		System.out.println("绝对路径："+src.getAbsolutePath());
		System.out.println("父路径："+src.getParent());
		System.out.println("是否存在："+src.exists());
		System.out.println("是否文件："+src.isFile());
		System.out.println("是否文件夹："+src.isDirectory());
		
		src=new File("C:/Users/82305/Desktop/java/learning");
		//list()：列出下级名称
		String[] subnames=src.list();
		for(String s:subnames) {
			System.out.println(s);
		}
		//listFiles()：列出下级File对象
		File [] files=src.listFiles();

	}
}
