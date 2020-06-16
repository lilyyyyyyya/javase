package com.yjn.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 数据流
 * 1.先写出后读取
 * 2.读取的顺序和写出的顺序一致
 * @author 82305
 *
 */
public class DataTest {
	public static void main(String[] args) throws IOException {
		//写出
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(baos));
		
		
		//操作数据类型加数据
		dos.writeUTF("编码");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		
		byte[]datas=baos.toByteArray();
		System.out.println(datas.length);//输出字节流大小
		
		//读取
		DataInputStream dis=new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String string=dis.readUTF();
		int age=dis.readInt();
		boolean flag=dis.readBoolean();
		char ch=dis.readChar();//按写出的顺序读取
		System.out.println(ch);
	}
}
