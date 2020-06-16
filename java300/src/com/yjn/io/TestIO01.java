package com.yjn.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * 分段读取：读到缓存中
 * 1.创造源
 * 2.选择流
 * 3。操作
 * 4.释放资源
 * @author 82305
 *
 */
public class TestIO01 {
	public static void main(String[] args) {
		File file=new File("gg.txt");
		InputStream inputStream=null;
		try {
			inputStream=new FileInputStream(file);
			byte[] flush=new byte[1024];//缓冲容器
			int len=-1;//接收长度
			while((len=inputStream.read(flush))!=-1) {
				//字节数组到字符串（解码）
				String string=new String(flush,0,len);
				System.out.println(string);
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
