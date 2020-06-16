package com.yjn.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 测试ip
 * @author 82305
 *
 */
public class IpTest {
	public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        //返回IP地址：192.168.116.1
        System.out.println(addr.getHostAddress());  
        //输出计算机名：DESKTOP-7ROTLGI
        System.out.println(addr.getHostName());   
        addr = InetAddress.getByName("www.sxt.cn");
        // 返回 sxt服务器的IP:101.200.85.121
        System.out.println(addr.getHostAddress());
        // 输出：www.sxt.cn
        System.out.println(addr.getHostName());
        addr = InetAddress.getByName("101.200.85.121");
        // 返回sxt服务器的IP101.200.85.121
        System.out.println(addr.getHostAddress());
        /*
         * 输出ip而不是域名。如果这个IP地址不存在或DNS服务器不允许进行IP地址
         * 和域名的映射，getHostName方法就直接返回这个IP地址。
         */
        System.out.println(addr.getHostName());
    }
}
