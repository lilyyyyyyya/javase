package com.yjn.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 创建客户端
 * 模拟登录 单向
 * 1.使用Socket创建客户端+服务器的地址和端口
 * 2.操作：io流
 * 3.释放资源
 * @author 82305
 *
 */
public class LoginClient {
	public static void main(String[] args) throws Exception{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String uname=bufferedReader.readLine();
		System.out.println("请输入密码：");
		String password=bufferedReader.readLine();
		//1
		Socket client=new Socket("localhost",8888);
		//2
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		
		dos.writeUTF("uname="+uname+"&password="+password);
		dos.flush();
		
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String data=dis.readUTF();
		System.out.println(data);
		
		//3
		dos.close();
		client.close();
	}
}
