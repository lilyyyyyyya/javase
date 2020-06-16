package com.yjn.tcp;


import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 熟悉TCP流程
 * 1.使用ServerSocket创建服务器  指定端口
 * 2.阻塞式等待连接 accept方法
 * 3.操作：io流
 * 4.释放资源
 * @author 82305
 *
 */
public class Server {
	public static void main(String[] args) throws Exception{
		//1
		ServerSocket server=new ServerSocket(8888);
		//2
		Socket socket=server.accept();
		System.out.println("一个客户端 建立了连接");
		//3
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		String data=dis.readUTF();
		System.out.println(data);
		//4
		dis.close();
		socket.close();
		server.close();//一般都不关闭
	}
}
