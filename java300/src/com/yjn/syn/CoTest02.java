package com.yjn.syn;
/**
 * 协作模型 生产者消费者实现
 * 方式二：信号灯法
 * 借助标志位
 * @author 82305
 *
 */
public class CoTest02 {
	public static void main(String[] args) {
		TV tv=new TV();
		new Player(tv).start();
		new Watcher(tv).start();
	}
}
//生产者演员
class Player extends Thread{
	TV tv;
	
	public Player(TV tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			if(i%2==0) {
				this.tv.play("奇葩说");
			}else {
				this.tv.play("广告");
			}
		}
	}
	
}
//消费者观众
class Watcher extends Thread{
	TV tv;
	
	public Watcher(TV tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			tv.watch();
		}
	}
	
}
//同一个资源 电视
class TV{
	String voice;
	//信号灯 True演员表演 观众等待
	//False 观众观看 演员等待
	boolean flag=true;
	
	
	//表演
	public synchronized void play(String voice) {
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("表演了:"+voice);
		this.voice=voice;
		this.notifyAll();
		this.flag=!this.flag;
	}
	
	//观看
	public synchronized void watch() {
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("听到了:"+voice);
		this.notifyAll();
		this.flag=!this.flag;
	}
	
}