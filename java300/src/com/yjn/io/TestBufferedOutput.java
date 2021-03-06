package com.yjn.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 测试文件字节输出流 加入缓存流
 * @author 82305
 *
 */
public class TestBufferedOutput {
	public static void main(String[] args) {
		File src=new File("test.txt");
		OutputStream outputStream=null;
		try {
			outputStream=new BufferedOutputStream(new FileOutputStream(src));//匿名对象
			String msString="change";
			byte []datas=msString.getBytes();
			outputStream.write(datas, 0, datas.length);
			outputStream.flush();//养成习惯 刷新一下
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(outputStream!=null) {
					outputStream.close();
				}
			} catch (Exception e) {
				
			}
		}
	}
}
