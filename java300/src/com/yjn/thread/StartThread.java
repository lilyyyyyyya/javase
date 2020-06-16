package com.yjn.thread;
/**
 * 创建线程方式一
 * @author 82305
 *
 */
public class StartThread extends Thread{
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("一边听歌");
		}
	}
	public static void main(String[] args) {
		//创建子类对象
		StartThread startThread=new StartThread();
		startThread.start();//不保证立即运行，由cpu调用
//		startThread.run();//只是普通方法的调用，不涉及多线程
		for(int i=0;i<20;i++) {
			System.out.println("一边coding");
		}
	}
}
