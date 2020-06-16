package com.yjn.udp;

import com.yjn.io.ChangePIC;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端
 * 1.使用DatagramSocket指定端口 创建接收端
 * 2.准备容器，封装成DatagramPacket包裹
 * 3.阻塞式接收包裹 receive
 * 4.分析数据 将字节数组还原成对应的类型
 * getData   getLength--》byte[]
 * 5.释放资源
 * @author 82305
 *
 */
public class UdpFileServer {
	public static void main(String[] args) throws Exception{
		System.out.println("接收方启动中....");
		//1.
		DatagramSocket server=new DatagramSocket(9999);
		//2
		byte[] container=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(container,0,container.length);
		//3.
		server.receive(packet);
		//4
		byte [] datas=packet.getData();
		int len=packet.getLength();
		
		ChangePIC.byteArrayToFile(datas, "bg1.jpg");
		
		//5
		server.close();
	}
}
