package com.yjn.io;

import java.io.UnsupportedEncodingException;

public class TestDecode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String string="性命 生命 使命";
		byte[] datas=string.getBytes();//默认使用工程的字符集
		
		string=new String(datas, 0, datas.length, "utf8");
		System.out.println(string);//解码
		
		//乱码原因：1.字节数不够
		
		string=new String(datas, 0, datas.length-2, "utf8");
		System.out.println(string);//解码
		
		//2.字符集不正确
		string=new String(datas, 0, datas.length-2, "gbk");
		System.out.println(string);//解码
	}
}
