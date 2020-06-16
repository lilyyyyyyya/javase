package com.yjn.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**
 * 测试文件字符输出流
 * @author 82305
 *
 */
public class TestBufferedWriter {
	public static void main(String[] args) {
		File src=new File("test.txt");
		Writer writer=null;
		try {
			writer=new FileWriter(src,false);//true代表在后面追加
			//写法一
			String msString="日常想嫁任豪";
//			char []datas=msString.toCharArray();
//			writer.write(datas, 0, datas.length);
			
			
			//写法二
			writer.write(msString);
			
			//写法三
			writer.append("日常想").append("嫁任豪");
			
			writer.flush();//养成习惯 刷新一下
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(writer!=null) {
					writer.close();
				}
			} catch (Exception e) {
				
			}
		}
	}
}
