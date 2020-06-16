package com.yjn.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 倒计时
 * @author 82305
 *
 */
public class BlockedSleep03 {
	public static void main(String[] args) throws InterruptedException {
		Date endTime=new Date(System.currentTimeMillis()+1000*10);
		long end=endTime.getTime();
		while(true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			Thread.sleep(1000);
			endTime=new Date(endTime.getTime()-1000);
			if(end-endTime.getTime()>=10000) {
				break;
			}
		}
	}
}
