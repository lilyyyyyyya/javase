package com.yjn.thread;
/**
 * yield直接进入就绪状态
 * @author 82305
 *
 */

public class YieldThread01 {
//	public static void main(String[] args) {
//		MyYield myYield=new MyYield();
//		new Thread(myYield, "a").start();
//		new Thread(myYield, "b").start();
//	}
	public static void main(String[] args) {
		new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("lambda...."+i);
			}
		}).start();
		for(int i=0;i<100;i++) {
			if(i%20==0) {
				Thread.yield();//main线程礼让
			}
			System.out.println("main..."+i);
		}
	}
}
class MyYield implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->start");
		Thread.yield();//礼让，可能成功，可能重回调度器调自己
		System.out.println(Thread.currentThread().getName()+"-->end");
		
	}
	
}