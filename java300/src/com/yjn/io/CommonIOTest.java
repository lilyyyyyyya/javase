package com.yjn.io;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * 使用commonio
 * @author 82305
 *
 */
public class CommonIOTest {
	public static void main(String[] args) throws IOException {
		//文件大小
		long len=FileUtils.sizeOf(new File("src/com/yjn/io/ConvertTest.java"));
		System.out.println(len);
		//目录大小
		len=FileUtils.sizeOf(new File("src"));
		System.out.println(len);
		Collection<File>files=FileUtils.listFiles(new File("C:\\Users\\82305\\Desktop\\java\\learning\\day5"), EmptyFileFilter.NOT_EMPTY, null);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		
		System.out.println("=======================");
		files=FileUtils.listFiles(new File("C:\\Users\\82305\\Desktop\\java\\learning\\day5"), 
				EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);//打印子孙级
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("=======================");
		files=FileUtils.listFiles(new File("C:\\Users\\82305\\Desktop\\java\\learning\\day5"), 
				new SuffixFileFilter(".java"), DirectoryFileFilter.INSTANCE);//后缀为java
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("=======================");
		files=FileUtils.listFiles(new File("C:\\Users\\82305\\Desktop\\java\\learning\\day5"), 
				FileFilterUtils.or(new SuffixFileFilter(".java"),new SuffixFileFilter(".class")), DirectoryFileFilter.INSTANCE);//后缀为java
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("=======================");
		//读取文件
		String mString=FileUtils.readFileToString(new File("gg.txt"),"utf8");
		System.out.println(mString);
		byte[]data=FileUtils.readFileToByteArray(new File("gg.txt"));
		System.out.println(data.length);
		//逐行读取
		List<String>list=FileUtils.readLines(new File("gg.txt"), "utf8");
		for(String string:list) {
			System.out.println(string);
		}
		LineIterator iterator=FileUtils.lineIterator(new File("gg.txt"));
		while(iterator.hasNext()) {
			System.out.println(iterator.nextLine());
		}
		System.out.println("=======================");
		//写出文件
		FileUtils.write(new File("test.txt"), "hhhhh");
		FileUtils.writeByteArrayToFile(new File("test.txt"), "ggggggg".getBytes("utf8"),true);
		List<String>datas=new ArrayList<>();
		datas.add("码云");
		datas.add("麻花疼");
		FileUtils.writeLines(new File("test.txt"), datas);
		
		//复制文件
//		FileUtils.copyFile(new File("bg.jpg"), new File("bg1.jpg"));
		//复制文件到目录
//		FileUtils.copyFileToDirectory(new File("bg.jpg"), new File("lib"));
		//复制目录到目录，成为她的子目录
//		FileUtils.copyDirectoryToDirectory(new File("src"), new File("lib"));
		//复制目录下的内容到目标目录中
//		FileUtils.copyDirectory(new File("src"), new File("lib"));
		//拷贝Url的内容
//		FileUtils.copyURLToFile(new URL(""), new File(""));
		//拷贝源码
		String html=IOUtils.toString(new URL("http://www.163.com"), "gbk");
		System.out.println(html);
		
	}
}
