package com.yjn.thread;


/**
 * sleep模拟休息时间
 * @author 82305
 *
 */
public class BlockedSleep02  implements Runnable{
//	private int steps=99;
	private static String winner;//胜利者
	@Override
	public void run() {
		for(int steps=1;steps<=100;steps++) {
			//模拟休息
			if("rabbit".equals(Thread.currentThread().getName())&&(steps%10==0)) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println(Thread.currentThread().getName()+"-->"+steps);
			boolean flag=gameOver(steps);
			if(flag) {
				break;
			}
		}
	}
	private boolean gameOver(int steps) {
		if(winner!=null) {
			return true;
		}else {
			if(steps==100) {
				winner=Thread.currentThread().getName();
				System.out.println("winner-->"+winner);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		BlockedSleep02 blockedSleep02=new BlockedSleep02();
		new Thread(blockedSleep02, "rabbit").start();
		new Thread(blockedSleep02,"wugui").start();
	}
}
