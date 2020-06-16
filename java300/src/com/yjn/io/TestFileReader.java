package com.yjn.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * 文件字符输入流
 * 1.创造源
 * 2.选择流
 * 3。操作
 * 4.释放资源
 * @author 82305
 *
 */
public class TestFileReader {
	public static void main(String[] args) {
		File file=new File("gg.txt");
		Reader reader=null;
		try {
			reader=new FileReader(file);
			char[]datas=new char[1024];
			int len=-1;
			while((len=reader.read(datas))!=-1) {
				String string=new String(datas, 0, len);
				System.out.println(string);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader!=null) {
					reader.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
