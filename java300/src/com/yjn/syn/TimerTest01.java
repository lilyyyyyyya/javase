package com.yjn.syn;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度：Timer和TimerTask类
 * @author 82305
 *
 */
public class TimerTest01 {
	public static void main(String[] args) {
		Timer timer=new Timer();
//		timer.schedule(new MyTask(), 1000);//执行任务一次
//		timer.schedule(new MyTask(), 1000,1000);//执行任务多次
		Calendar calendar=new GregorianCalendar(2020,6,1,16,39,00);
		timer.schedule(new MyTask(), calendar.getTime(), 1000);
	}
}
class MyTask extends TimerTask{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("防空");
		}
		System.out.println("=================");
	}
}