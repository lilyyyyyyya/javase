package com.yjn.tcp;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 存储文件
 * 1.使用ServerSocket创建服务器  指定端口
 * 2.阻塞式等待连接 accept方法
 * 3.操作：io流
 * 4.释放资源
 * @author 82305
 *
 */
public class FileServer {
	public static void main(String[] args) throws Exception{
		//1
		ServerSocket server=new ServerSocket(8888);
		//2
		Socket socket=server.accept();
		System.out.println("一个客户端 建立了连接");
		//3
		InputStream is=new BufferedInputStream(socket.getInputStream());
		OutputStream os=new BufferedOutputStream(new FileOutputStream(new File("bg1.jpg")));
		byte[]data=new byte[1024];
		int len=-1;
		while((len=is.read(data))!=-1) {
			os.write(data, 0, len);
		}
		os.flush();
		
		os.close();
		is.close();
		//4
		socket.close();
		server.close();//一般都不关闭
	}
}
