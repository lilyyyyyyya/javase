package com.yjn.chat;

import java.awt.List;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.io.output.ThresholdingOutputStream;

/**
 * 在线聊天室 服务端
 * @author 82305
 *
 */
public class Chat {
	private static CopyOnWriteArrayList<Channel>all=new CopyOnWriteArrayList();
	public static void main(String[] args) throws IOException {
		System.out.println("-----Server-------");
		ServerSocket server=new ServerSocket(8888);
		while(true) {
			Socket socket=server.accept();
			System.out.println("一个客户端 建立了连接");
			Channel channel=new Channel(socket);
			all.add(channel);
			new Thread(channel).start();
			
			
		}
	}
	

	//一个客户代表一个channel
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		private String name;
		
		
		
		public Channel(Socket client) {
			this.client=client;
			
			try {
				dis = new DataInputStream(client.getInputStream());
				dos=new DataOutputStream(client.getOutputStream());
				this.isRunning=true;
				this.name=receive();
				this.send("欢迎您的到来");
				sendOthers(this.name+"进入聊天室", true);
			} catch (IOException e1) {
				System.out.println("---------1----------");
				release();
			}
		}
		
		@Override
		public void run() {
			while(isRunning) {
				String msString=receive();
				if(!msString.equals("")) {
					sendOthers(msString,false);
				}
			}
		}
		
		
		
		
		//接收消息
		public String receive() {
			String string="";
			try {
				string = dis.readUTF();
			} catch (IOException e) {
				System.out.println("---------2----------");
				release();
			}
			return string;
		}
		//发送消息
		public void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				System.out.println("---------3----------");
				release();
			}
			
		}
		//群聊
		//私聊格式@xxx:msg
		public void sendOthers(String msg,boolean isSys) {
			boolean isPrivate=msg.startsWith("@");
			if(isPrivate) {
				int index=msg.indexOf(":");
				String targetName=msg.substring(1,index);
				String message=msg.substring(index+1);
				for(Channel other:all) {
					if(other.name.equals(targetName)) {
						other.send(this.name+"悄悄地对您说："+message);
					}
				}
			}else {
				for(Channel other:all) {
					if(this==other) {
						continue;
					}else {
						if(!isSys) {
							other.send(this.name+"对所有人说："+msg);
						}else {
							other.send(msg);
						}
					}
				}
			}
			
			
		}
		//释放资源
		public void release() {
			this.isRunning=false;
			ReleaseUtil.close(dis,dos,client);
			all.remove(this);
			sendOthers(this.name+"离开聊天室", true);
		}
	}
}
