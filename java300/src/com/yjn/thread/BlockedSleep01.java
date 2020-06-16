package com.yjn.thread;

/**
 * sleep模拟网络延时，放大了发生问题的可能性
 * @author 82305
 *
 */
public class BlockedSleep01 {
	public static void main(String[] args) {
		Web12306 w1=new Web12306();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(w1, "lily").start();
		new Thread(w1, "lucy").start();
		new Thread(w1, "hjx").start();
	}
}

class Web12306 implements Runnable{
	private int tickets=99;

	@Override
	public void run() {
		while(true) {
			if(tickets<0) {
				break;
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
	
}