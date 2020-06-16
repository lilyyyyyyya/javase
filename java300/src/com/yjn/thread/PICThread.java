package com.yjn.thread;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * 
 * @author 82305
 *
 */
public class PICThread extends Thread{
	private String url;
	private String name;
	
	public PICThread(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}
	@Override
	public void run() {
		WebDownLoader wd=new WebDownLoader();
		wd.download(url, name);
		System.out.println(name);
	}
	public static void main(String[] args) {
		PICThread picThread1=new PICThread("http://p1.pstatp.com/large/403c00037462ae2eee13", "book1.jpg");
		PICThread picThread2=new PICThread("http://p1.pstatp.com/large/403c00037462ae2eee13", "book2.jpg");
		PICThread picThread3=new PICThread("http://p1.pstatp.com/large/403c00037462ae2eee13", "book3.jpg");
		
		picThread1.start();
		picThread2.start();
		picThread3.start();
		
	}
}
class WebDownLoader{
	public void download(String url,String name) {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("不合法的路径");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("下载失败");
		}
	}
}