package com.yjn.syn;
/**
 * 线程不安全，出现负数和相同的情况
 * @author 82305
 *
 */

public class UnsafeTest01 {
	public static void main(String[] args) {
		UnsafeWeb12306 w1=new UnsafeWeb12306();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(w1, "lily").start();
		new Thread(w1, "lucy").start();
		new Thread(w1, "hjx").start();
	}
}
class UnsafeWeb12306 implements Runnable{
	private int tickets=10;
	private boolean flag=true;

	@Override
	public void run() {
		while(flag) {
			test();
		}
		
	}
	public void test() {
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