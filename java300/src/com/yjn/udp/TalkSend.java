package com.yjn.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

import javax.swing.plaf.basic.BasicSliderUI.ScrollListener;

/**
 * 发送端
 * @author 82305
 *
 */
public class TalkSend implements Runnable{
	private DatagramSocket client;
	private BufferedReader bufferedReader;
	private String toIP;
	private int toPort;
	public TalkSend(int port,String toIP,int toPort) {
		this.toIP=toIP;
		this.toPort=toPort;
		try {
			client=new DatagramSocket(port);
			bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(true) {
			String string;
			try {
				string = bufferedReader.readLine();
				byte [] datas=string.getBytes();
				//3
				DatagramPacket datagramPacket=new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIP, this.toPort));
				//4.
				client.send(datagramPacket);
				if(string.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		client.close();
		
	}
	
}
