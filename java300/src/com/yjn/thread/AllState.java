package com.yjn.thread;

import java.lang.Thread.State;

/**
 * 观察线程的状态
 * @author 82305
 *
 */
public class AllState {
	public static void main(String[] args) {
		Thread thread=new Thread(()->{
			
			for(int i=0;i<5;i++) {
				try {
					Thread.sleep(100);
					System.out.println(".......");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}) ;
		//观察状态
		State state=thread.getState();
		System.out.println(state.toString());
		
		thread.start();
		state=thread.getState();
		System.out.println(state.toString());
		
//		while(state!=Thread.State.TERMINATED) {
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			state=thread.getState();
//			System.out.println(state.toString());
//		}
		
		while(true) {
			int t=Thread.activeCount();//活动的线程数
			System.out.println(t);
			if(t==1) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			state=thread.getState();
			System.out.println(state.toString());
		}
		
		
		
		
		
		
	}
}
