package com.yjn.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * 简单的爬虫+模拟浏览器
 * @author 82305
 *
 */
public class SpiderTest {
	public static void main(String[] args) throws Exception {
		//获取url
		URL url=new URL("https://www.dianping.com");
		
		//下载资源
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36");
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String msString=null;
		while((msString=bufferedReader.readLine())!=null) {
			System.out.println(msString);
		}
		bufferedReader.close();
		//分析
		//处理。。。spark
	}
}
