package com.yjn.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ChangePIC {
	public static void main(String[] args) {

		byte[] bs=fileToByteArray("bg.jpg");
		System.out.println(bs.length);
		byteArrayToFile(bs, "bg1.jpg");
	}
	
	//图片到字节数组中-->图片到程序，程序到字节数组
	public static byte[] fileToByteArray(String filePath) {
		File file=new File(filePath);
		InputStream inputStream=null;
		byte []dest=null;
		ByteArrayOutputStream baos=null;
		
		try {
			inputStream=new FileInputStream(file);
			baos=new ByteArrayOutputStream();
			byte[]datas=new byte[1024];
			int len=-1;
			while((len=inputStream.read(datas))!=-1) {
				baos.write(datas, 0, len);//写出到字节数组中
			}
			baos.flush();
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(inputStream!=null) {
					inputStream.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	
	//字节数组到文件-->字节数组读取到程序，程序到文件
	public static void byteArrayToFile(byte[] data,String filePath) {
		File file=new File(filePath);
		OutputStream outputStream=null;
		ByteArrayInputStream bais=null;
		try {
			bais=new ByteArrayInputStream(data);
			outputStream=new FileOutputStream(file);
			byte []flush=new byte[5];
			int len=-1;
			while((len=bais.read(flush))!=-1) {
				outputStream.write(flush, 0, len);
			}
			outputStream.flush();
		} catch (Exception e) {
			// TODO: handle exception
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
