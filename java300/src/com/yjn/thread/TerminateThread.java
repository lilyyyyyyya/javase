package com.yjn.thread;
/**
 * 终止线程：
 * 1.线程正常执行完毕--》次数
 * 2.外部干涉--》加入标志位
 * @author 82305
 *
 */
public class TerminateThread implements Runnable{
	//1.加入标志
	private boolean flag=true;
	private String name;
	
	public TerminateThread(String name) {
		super();
		this.name = name;
	}
	@Override
	//2.关联标志
	public void run() {
		int i=0;
		while(flag) {
			System.out.println(name+"-->"+i++);
		}
		
	}
	//3.对外提供方法，改变标志
	public void terminate() {
		this.flag=false;
	}
	public static void main(String[] args) {
		TerminateThread terminateThread=new TerminateThread("Thread1");
		new Thread(terminateThread).start();
		
		for(int i=0;i<99;i++) {
			if(i==88) {
				terminateThread.terminate();//线程的终止
				System.out.println("tt gameover");
			}
			System.out.println("main-->"+i);
		}
	}
}
