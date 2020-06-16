package com.yjn.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{
	private BufferedReader bufferedReader;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	private String name;
	public Send(Socket client,String name) {
		this.client=client;
		this.name=name;
		this.isRunning=true;
		bufferedReader= new BufferedReader(new InputStreamReader(System.in));
		try {
			
			dos=new DataOutputStream(client.getOutputStream());
			send(name);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			release();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			String msg=getStr();
			send(msg);
		}
	}
	
	
	public void send(String string) {
		try {
			dos.writeUTF(string);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			release();
		}
	}
	
	
	private String getStr() {
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public void release() {
		this.isRunning=false;
		ReleaseUtil.close(dos,client);
	}
}
