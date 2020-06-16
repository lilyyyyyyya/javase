package com.yjn.thread;
/**
 * 创建线程方式二
 * @author 82305
 *
 */

public class RunnableTest implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("一边听歌");
		}
	}
	public static void main(String[] args) {
		//创建子类对象
		RunnableTest runnableTest=new RunnableTest();
		Thread thread =new Thread(runnableTest);//不保证立即运行，由cpu调用
		thread.start();
//		startThread.run();//只是普通方法的调用，不涉及多线程
		for(int i=0;i<20;i++) {
			System.out.println("一边coding");
		}
	}
}
