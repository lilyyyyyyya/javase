package com.yjn.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;


/**
 * 转换流
 * InputStreamReader/OutputStreamWriter
 * @author 82305
 *
 */
public class ConvertTest {
	public static void main(String[] args) {
//		try (BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));){//jdk自动关闭
//			//循环获取键盘输入，打印此内容
//			String msString="";
//			while(!msString.equals("exit")) {
//				msString=reader.readLine();
//				writer.write(msString);
//				writer.newLine();
//				writer.flush();//强制刷新，可能没达到缓冲
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try(InputStreamReader is=new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8")) {
//			//解决了中文的乱码问题
//			int temp=-1;
//			while((temp=is.read())!=-1) {
//				System.out.print((char)temp);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		
		try(BufferedReader is=
				new BufferedReader(
				    new InputStreamReader(
				        new URL("http://www.baidu.com").openStream(),"UTF-8"));
				BufferedWriter os=
						new BufferedWriter(
						    new OutputStreamWriter(
						        new FileOutputStream("baidu.html")));) {
			//加入了缓冲流
			String string=null;
			while((string=is.readLine())!=null) {
				os.write(string);
				os.newLine();
				os.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
