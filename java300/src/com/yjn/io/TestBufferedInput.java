package com.yjn.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * 分段读取：读到缓存中 加入缓存流
 * 1.创造源
 * 2.选择流
 * 3。操作
 * 4.释放资源
 * @author 82305
 *
 */
public class TestBufferedInput {
	public static void main(String[] args) {
		File file=new File("gg.txt");
		InputStream inputStream=null;//由OS管理，OS释放
		BufferedInputStream bis=null;//JVM维护，由GC（垃圾回收机制）处理
		
		try {
			inputStream=new FileInputStream(file);
			bis=new BufferedInputStream(inputStream);
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
		}finally {//从里面开始关
			try {//可以省略
				if(inputStream!=null) {
					inputStream.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(bis!=null) {
					bis.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
