package com.yjn.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 创建客户端
 * 模拟登录 多个客户端请求
 * 1.使用Socket创建客户端+服务器的地址和端口
 * 2.操作：io流
 * 3.释放资源
 * @author 82305
 *
 */
public class LoginMultiClient {
	public static void main(String[] args) throws Exception{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String uname=bufferedReader.readLine();
		System.out.println("请输入密码：");
		String password=bufferedReader.readLine();
		//1
		Socket client=new Socket("localhost",8888);
		//2
		
		
		new Send(client).send("uname="+uname+"&password="+password);
		new Receive(client).receive();
		
		client.close();
	}
	
	static class Send{
		private Socket client;
		private DataOutputStream dos;
		public Send(Socket client) {
			this.client=client;
			try {
				dos=new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	static class Receive{
		private Socket client;
		private DataInputStream dis;
		public Receive(Socket client) {
			this.client=client;
			try {
				dis=new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void receive() {
			String data;
			try {
				data = dis.readUTF();
				System.out.println(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
}
