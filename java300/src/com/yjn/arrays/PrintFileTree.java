package com.yjn.arrays;

import java.io.File;

/**
 * 使用递归算法打印目录树
 * @author 82305
 *
 */
public class PrintFileTree {
	public static void main(String[] args) {
		File file=new File("C:\\Users\\82305\\Desktop\\3\\软件测试");
		printFile(file,0);
	}
	public static void printFile(File file,int level) {
		for(int i=0;i<level;i++) {
			System.out.print("-");
		}
		System.out.println(file.getName());
		if(file.isDirectory()) {
			File[] files=file.listFiles();
			for(File f:files) {
				printFile(f,level+1);
			}
		}
	}
}
