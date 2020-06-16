package com.yjn.thread;
/**
 * 守护线程：是为用户线程服务
 * jvm停止不用等待守护线程执行完毕
 * 默认线程：用户线程
 * @author 82305
 *
 */
public class DaemonTest {
	public static void main(String[] args) {
		
		You1 you=new You1();
		God god=new God();
		Thread thread=new Thread(god);
		thread.setDaemon(true);//将用户线程调整为守护
		thread.start();
		new Thread(you).start();
		
	}
}
class You1 implements Runnable{
	@Override
	public void run() {
		for(int i=1;i<=365;i++) {
			System.out.println("happy life...");
		}
		System.out.println("oooooo...");
	}
}
class God implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println("god bless you");
		}
	}
}