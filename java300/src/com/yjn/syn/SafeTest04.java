package com.yjn.syn;
/**
 * 线程安全，在并发时保证数据的准确性，效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 * 优化12306性能
 * @author 82305
 *
 */

public class SafeTest04 {
	public static void main(String[] args) {
		SynWeb12306 w1=new SynWeb12306();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(w1, "lily").start();
		new Thread(w1, "lucy").start();
		new Thread(w1, "hjx").start();
	}
}
class SynWeb12306 implements Runnable{
	private int tickets=10;
	private boolean flag=true;

	@Override
	public void run() {
		while(flag) {
			test();
		}
		
	}
	//改成同步块，尽可能锁定合理的范围（不是指代码，指的是数据的完整性）
	public void test() {
		if(tickets<=0) {//考虑没有票的情况，缩小了锁定范围
			flag=false;
			return;
		}
		synchronized (this) {//不能写(tickets,flag)
			if(tickets<=0) {//考虑最后一张票的情况，不加这个锁不住，出现临界值问题，多线程中叫双层检测
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
	
}