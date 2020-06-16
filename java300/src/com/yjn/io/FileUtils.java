package com.yjn.io;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1.封装拷贝
 * 2.封装释放资源
 * @author 82305
 *
 */
public class FileUtils {
	public static void main(String[] args) {
		
	}
	/**
	 * 对接输入输出流
	 * @param is
	 * @param os
	 */
	public static void copy(InputStream is,OutputStream os) {
		try {
			byte[] flush=new byte[1024];
			int len=-1;
			while((len=is.read(flush))!=-1) {
				System.out.println(len);
				os.write(flush, 0, len);
				
			}
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(is, os);
		}
	}
	/**
	 * 释放资源
	 * @param is
	 * @param os
	 */
	public static void close(InputStream is,OutputStream os) {
		try {
			if(os!=null) {
				os.close();
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
		try {
			if(is!=null) {
				is.close();
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
	public static void close(Closeable... ios) {
		for(Closeable io:ios) {
			try {
				if(io!=null) {
					io.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
}
