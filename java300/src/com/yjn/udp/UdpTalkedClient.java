package com.yjn.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 多次交流 发送端
 * 1.使用DatagramSocket指定端口 创建发送端
 * 2.准备数据 转成字节数组，
 * 3.封装成DatagramPacket包裹，指定目的地
 * 4.发送包裹 send
 * 5.释放资源
 * @author 82305
 *
 */
public class UdpTalkedClient {
	public static void main(String[] args) throws Exception{
		System.out.println("发送方启动中...");
		//1
		DatagramSocket client=new DatagramSocket(8888);
		//2
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String string=bufferedReader.readLine();
			byte [] datas=string.getBytes();
			//3
			DatagramPacket datagramPacket=new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
			//4.
			client.send(datagramPacket);
			if(string.equals("bye")) {
				break;
			}
		}
		
		//5.
		client.close();
	}
}
