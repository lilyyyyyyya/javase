package com.yjn.net;

import java.net.InetSocketAddress;

/**
 * 端口
 * 1.区分软件
 * 2.两个字节0-65535 UDP TCP独立
 * 3.同一个协议端口不能冲突
 * 4.定义端口越大越好
 * 
 * @author 82305
 * 构造器
 * new InetSocketAddress(域名, 端口)
 * 方法
 * getAddress()
 * getPort()
 * 
 */
public class PortTest {
	public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost", 9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress2.getAddress());
        System.out.println(socketAddress2.getPort());
    }
}
