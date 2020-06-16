package com.yjn.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端
 * @author 82305
 *
 */
public class TalkReceive implements Runnable{
	private DatagramSocket server;
	
	public TalkReceive(int port) {
		
		try {
			server=new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		while(true) {
			byte[] container=new byte[1024*60];
			DatagramPacket packet=new DatagramPacket(container,0,container.length);
			//3.
			try {
				server.receive(packet);
				//4
				byte [] datas=packet.getData();
				int len=packet.getLength();
				String data=new String(datas, 0, len);
				System.out.println(data);
				if(data.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		//5
		server.close();
		
	}
}
