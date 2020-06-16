package com.yjn.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 上传文件
 * 1.使用Socket创建客户端+服务器的地址和端口
 * 2.操作：io流
 * 3.释放资源
 * @author 82305
 *
 */
public class FileClient {
	public static void main(String[] args) throws Exception{
		//1
		Socket client=new Socket("localhost",8888);
		//2
		InputStream is=new BufferedInputStream(new FileInputStream(new File("bg.jpg")));
		OutputStream os=new BufferedOutputStream(client.getOutputStream());
		byte[]data=new byte[1024];
		int len=-1;
		while((len=is.read(data))!=-1) {
			os.write(data, 0, len);
		}
		os.flush();
		//3
		os.close();
		is.close();
		client.close();
	}
}
