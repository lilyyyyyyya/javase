package com.yjn.tcp;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * 模拟登录 多个客户端请求
 * 1.使用ServerSocket创建服务器  指定端口
 * 2.阻塞式等待连接 accept方法
 * 3.操作：io流
 * 4.释放资源
 * @author 82305
 *
 */
public class LoginMultiServer {
	public static void main(String[] args) throws Exception{
		//1
		ServerSocket server=new ServerSocket(8888);
		//2
		boolean isRunning=true;
		while(isRunning) {
			Socket socket=server.accept();
			System.out.println("一个客户端 建立了连接");
			new Thread(new Channel(socket)).start();
		}
		
		server.close();//一般都不关闭
	}
	
	static class Channel implements Runnable{
		private Socket socket;
		private DataInputStream dis;
		private DataOutputStream dos;
		public Channel(Socket ch) {
			this.socket=ch;
			try {
				dis = new DataInputStream(socket.getInputStream());
				dos=new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				release();
			}
		}
		
		private String receive() {
			String data="";
			try {
				data = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data;
		}
		
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		private void release() {
			try {
				if(dos!=null) {
					dos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(dis!=null) {
					dis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(socket!=null) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			
			String uname="";
			String upwd="";
			String [] dataArray=receive().split("&");
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
			
			if(uname.equals("yjn")&&upwd.equals("lily0519")) {
				send("登录成功，欢迎！");;
			}else {
				send("用户名或密码错误");;
			}
			//4
			release();
		}
		
	}
}
