package com.yjn.tcp;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 * 熟悉TCP流程
 * 1.使用Socket创建客户端+服务器的地址和端口
 * 2.操作：io流
 * 3.释放资源
 * @author 82305
 *
 */
public class Client {
	public static void main(String[] args) throws Exception{
		//1
		Socket client=new Socket("localhost",8888);
		//2
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		String data="hello";
		dos.writeUTF(data);
		dos.flush();
		//3
		dos.close();
		client.close();
	}
}
