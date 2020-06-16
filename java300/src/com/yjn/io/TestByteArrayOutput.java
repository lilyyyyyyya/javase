package com.yjn.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 测试字节数组输出流
 * 1.创造源：内部维护
 * 2.选择流：不关联源，不适用多态
 * 3。操作
 * 4.释放资源：可以不用处理
 * 跟内存打交道，而不是硬盘
 * 获取数据：toByteArray
 * @author 82305
 *
 */
public class TestByteArrayOutput {
	public static void main(String[] args) {
		byte [] dest=null;
		ByteArrayOutputStream outputStream=null;//使用新增方法，不能多态
		try {
			outputStream=new ByteArrayOutputStream();
			String msString="change";
			byte []datas=msString.getBytes();
			outputStream.write(datas, 0, datas.length);
			outputStream.flush();//养成习惯 刷新一下
			
			//获取数据
			dest=outputStream.toByteArray();
			System.out.println(dest.length);
			
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
