package com.yjn.udp;

import java.io.BufferedOutputStream;
import com.yjn.io.ChangePIC;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 基本类型  发送端
 * 1.使用DatagramSocket指定端口 创建发送端
 * 2.基本类型 转成字节数组，
 * 3.封装成DatagramPacket包裹，指定目的地
 * 4.发送包裹 send
 * 5.释放资源
 * @author 82305
 *
 */
public class UdpFileClient {
	public static void main(String[] args) throws Exception{
		System.out.println("发送方启动中...");
		//1
		DatagramSocket client=new DatagramSocket(8888);
		//2
		byte[] datas=ChangePIC.fileToByteArray("bg.jpg");
		//3
		DatagramPacket datagramPacket=new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
		//4.
		client.send(datagramPacket);
		//5.
		client.close();
	}
}
