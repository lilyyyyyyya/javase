package com.yjn.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 1.创造源
 * 2.选择流
 * 3。操作
 * 4.释放资源
 * @author 82305
 *
 */
public class TestIO {
	public static void main(String[] args) {
		File file=new File("gg.txt");
		InputStream inputStream=null;
		try {
			inputStream=new FileInputStream(file);
			int temp;
			while((temp=inputStream.read())!=-1) {
				System.out.println((char)temp);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(inputStream!=null) {
					inputStream.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
