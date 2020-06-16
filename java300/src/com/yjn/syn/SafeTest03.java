package com.yjn.syn;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 操作容器  线程安全
 * @author 82305
 *
 */
public class SafeTest03 {
	public static void main(String[] args) throws InterruptedException {
		List<String>list=new ArrayList<>();
		for(int i=0;i<100;i++) {
			new Thread(()->{
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
				
			}) .start();
		}
		Thread.sleep(10000);
		System.out.println(list.size());//不是100，有些线程丢掉了
	}
}
