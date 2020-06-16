package com.yjn.thread;
/**
 * join 合并
 * @author 82305
 *
 */
public class BlockedJoin {
//	public static void main(String[] args) throws InterruptedException {
//		Thread t=new Thread(()->{
//			for(int i=0;i<100;i++) {
//				System.out.println("lambda...."+i);
//			}
//		});
//		t.start();
//		for(int i=0;i<100;i++) {
//			if(i==20) {
//				t.join();//插队，main被阻塞
//			}
//			System.out.println("main..."+i);
//		}
//	}
	
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("爸爸儿子买烟");
		new Thread(new Father()).start();
	}
}
class Father extends Thread{
	@Override
	public void run() {
		System.out.println("想抽烟，发现没有");
		System.out.println("让儿子去买中华");
		Thread thread=new Thread(new Son());
		thread.start();
		try {
			thread.join();
			System.out.println("老爸接过烟 把零钱给儿子");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("孩子走丢了，老爸去找孩子");
		}
		
	}
}
class Son extends Thread{
	@Override
	public void run() {
		System.out.println("接过老爸的钱出去了");
		System.out.println("路边有游戏厅 玩了10秒");
		for(int i=0;i<10;i++) {
			System.out.println(i+"秒过去了");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("赶紧买烟去");
		
		System.out.println("手拿中华回家");
	}
}
