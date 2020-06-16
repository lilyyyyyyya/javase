package com.yjn.tcp;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * 模拟登录 单向
 * 1.使用ServerSocket创建服务器  指定端口
 * 2.阻塞式等待连接 accept方法
 * 3.操作：io流
 * 4.释放资源
 * @author 82305
 *
 */
public class LoginServer {
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
		String uname="";
		String upwd="";
		String [] dataArray=data.split("&");
		for(String info:dataArray) {
			String [] userInfo=info.split("=");
			if(userInfo[0].equals("uname")) {
				System.out.println("你的用户名为："+userInfo[1]);
				uname=userInfo[1];
			}else if(userInfo[0].equals("password")) {
				System.out.println("你的用户名为："+userInfo[1]);
				upwd=userInfo[1];
			}
		}
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		if(uname.equals("yjn")&&upwd.equals("lily0519")) {
			dos.writeUTF("登录成功，欢迎！");;
		}else {
			dos.writeUTF("用户名或密码错误");;
		}
		dos.flush();
		//4
		dis.close();
		socket.close();
		server.close();//一般都不关闭
	}
}
