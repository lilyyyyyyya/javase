package com.yjn.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
	private DataInputStream dis;
	private Socket client;
	private boolean isRunning;
	public Receive(Socket client) {
		this.client=client;
		this.isRunning=true;
		try {
			dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			String mString=receive();
			if(!mString.equals("")) {
				System.out.println(mString);
			}
		}
	}
	public String receive() {
		String data="";
		try {
			data=dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			release();
		}
		return data;
	}
	
	public void release() {
		this.isRunning=false;
		ReleaseUtil.close(dis,client);
	}

}
