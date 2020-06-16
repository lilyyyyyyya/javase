package com.yjn.arrays;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {
	public static void main(String[] args) throws IOException {
		File file=new File("C:\\Users\\82305\\Desktop\\3\\java300\\a.txt");
		System.out.println(file);
		file.renameTo(new File("C:\\Users\\82305\\Desktop\\3\\java300\\b.txt"));//改名字
		System.out.println(System.getProperty("user.dir"));
		File f=new File("gg.txt");
//		f.createNewFile();//创建新文件
		
		System.out.println("File是否存在："+f.exists());
        System.out.println("File是否是目录："+f.isDirectory());
        System.out.println("File是否是文件："+f.isFile());
        System.out.println("File最后修改时间："+new Date(f.lastModified()));
        System.out.println("File的大小："+f.length());
        System.out.println("File的文件名："+f.getName());
        System.out.println("File的目录路径："+f.getPath());
	}
}
