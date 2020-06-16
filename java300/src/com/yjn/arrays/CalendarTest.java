package com.yjn.arrays;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 可视化日历程序
 * @author 82305
 *
 */
public class CalendarTest {
	public static void main(String[] args) throws ParseException {
		System.out.println("请输入日期(格式:2020-9-10):");
		Scanner scanner=new Scanner(System.in);
		String str=scanner.nextLine();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date date=df.parse(str);
		Calendar calendar=new GregorianCalendar();
		calendar.setTime(date);
		int day=calendar.get(Calendar.DATE);
		calendar.set(Calendar.DATE, 1);
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		for(int i=0;i<calendar.get(Calendar.DAY_OF_WEEK)-1;i++) {
			System.out.print("\t");
		}
		int maxDate=calendar.getActualMaximum(Calendar.DATE);
		for(int i=1;i<=maxDate;i++) {
			if(i==day) {
				System.out.print(calendar.get(Calendar.DATE)+"*\t");
			}else {
				System.out.print(calendar.get(Calendar.DATE)+"\t");
			}

			if(calendar.get(Calendar.DAY_OF_WEEK)==7) {
				System.out.println();
			}
			calendar.add(Calendar.DATE, 1);
		}
	}
}
