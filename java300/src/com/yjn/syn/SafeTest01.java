package com.yjn.syn;
/**
 * 线程安全，在并发时保证数据的准确性，效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 * 
 * @author 82305
 *
 */

public class SafeTest01 {
	public static void main(String[] args) {
		SafeWeb12306 w1=new SafeWeb12306();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(w1, "lily").start();
		new Thread(w1, "lucy").start();
		new Thread(w1, "hjx").start();
	}
}
class SafeWeb12306 implements Runnable{
	private int tickets=10;
	private boolean flag=true;

	@Override
	public void run() {
		while(flag) {
			test();
		}
		
	}
	public synchronized void test() {
		if(tickets<0) {
			flag=false;
			return;
		}
		//模拟延时
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-->"+tickets--);
	}
	
}