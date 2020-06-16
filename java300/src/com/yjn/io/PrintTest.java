package com.yjn.io;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 打印流PrintStream/PrintWriter
 * @author 82305
 *
 */
public class PrintTest {
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter printWriter=new PrintWriter(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
		printWriter.println("111");
		printWriter.println();
		printWriter.close();
		
		
		PrintStream printStream=System.out;
		printStream.println("打印流");
		printStream.print(false);
		
		printStream=new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
		//true代表自动刷新
		printStream.println("打印流");
		printStream.println(false);
		
		//重定向输出端
		//sysout输出到控制台
		System.setOut(printStream);
		System.out.println("change");
		
		//重定向回控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("I am back");
		printStream.close();
	}
}
