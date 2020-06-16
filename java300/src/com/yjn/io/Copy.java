package com.yjn.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 使用文件字节输入输出流拷贝文件
 * @author 82305
 *
 */

public class Copy {
	public static void main(String[] args) {
		File input=new File("gg.txt");
		File output=new File("test.txt");
		InputStream inputStream =null;
		OutputStream outputStream=null;
		try {
			inputStream=new FileInputStream(input);
			outputStream=new FileOutputStream(output);
			byte[] flush=new byte[1024];
			int len=-1;
			while((len=inputStream.read(flush))!=-1) {
				System.out.println(len);
				outputStream.write(flush, 0, len);
				
			}
			outputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(outputStream!=null) {
					outputStream.close();
				}
				if(inputStream!=null) {
					inputStream.close();//先打开的后关闭
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
