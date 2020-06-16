package com.yjn.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 在线聊天室 客户端
 * @author 82305
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("---------Client---------");
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String name=bufferedReader.readLine();
		Socket client=new Socket("localhost",8888);
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
	}
}
