package com.yjn.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * 字节数组输入流
 * 1.创造源：字节数组 不要太大
 * 2.选择流
 * 3。操作
 * 4.释放资源：可以不用处理
 * @author 82305
 *
 */
public class TestByteArrayInput {
	public static void main(String[] args) {
		byte []datas="miaomiaomiao".getBytes();
		InputStream inputStream=null;
		try {
			inputStream=new ByteArrayInputStream(datas);
			byte []flush=new byte[5];
			int len=-1;
			while((len=inputStream.read(flush))!=-1) {
				String string=new String(flush, 0, len);
				System.out.println(string);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(inputStream!=null) {
					inputStream.close();//保证风格统一
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
