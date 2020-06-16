package com.yjn.arrays;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {
	public static void main(String[] args) {
		Calendar calendar=new GregorianCalendar(2020,2,9,22,10,5);
		System.out.println(calendar);
		int month=calendar.get(Calendar.MONTH);
		System.out.println(month);//0代表1月....
		int weekday=calendar.get(Calendar.DAY_OF_WEEK);//星期几，1表示星期日....7表示星期六
		System.out.println(weekday);
		int day=calendar.get(Calendar.DATE);//得到几号，也可以使用dayofmonth
		System.out.println(day);
		
		//设置日期相关元素
		Calendar c1=new GregorianCalendar();//默认生成今天日期时间
		System.out.println(c1);
		c1.set(Calendar.YEAR, 2020);
		System.out.println(c1);
		
		//日期的计算
		c1.add(Calendar.DATE, 100);//计算往后一百天
		System.out.println(c1);
		c1.add(Calendar.DATE, -100);//计算往前一百天
		System.out.println(c1);
		
		//日期对象和时间对象的转化
		Date date=c1.getTime();//gettime从calendar到date
		Calendar calendar2=new GregorianCalendar();
		calendar2.setTime(date);//settime从date到calendar
		printCalendar(calendar2);
	}
	
	
	public static void printCalendar(Calendar calendar) {
		//打印 2020年10月10日 11:12:12 周三
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH)+1;
		int day=calendar.get(Calendar.DATE);
		int dayweek=calendar.get(Calendar.DAY_OF_WEEK)-1;
		String dayweek2=dayweek==0?"日":dayweek+"";
		int hour=calendar.get(Calendar.HOUR);
		int minute=calendar.get(Calendar.MINUTE);
		int second=calendar.get(Calendar.SECOND);
		System.out.println(year+"年"+month+"月"+day+"日 "+hour+"时"+minute+"分"+second+"秒 "+"周"+dayweek2);
	}
}
