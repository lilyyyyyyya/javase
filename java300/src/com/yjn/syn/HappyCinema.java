package com.yjn.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * 快乐影院
 * @author 82305
 *
 */
public class HappyCinema {
	public static void main(String[] args) {
		List<Integer>available=new ArrayList<>();
		available.add(1);
		available.add(2);
		available.add(3);
		available.add(4);
		available.add(5);
		
		List<Integer>seats1=new ArrayList<>();
		seats1.add(1);
		seats1.add(2);
		
		
		List<Integer>seats2=new ArrayList<>();
		seats2.add(3);
		seats2.add(5);
		Cinema cinema=new Cinema(available, "happy");
		new Thread(new Customer(cinema,seats1),"yjn").start();
		new Thread(new Customer(cinema,seats2),"hjx").start();
	}
}


class Customer implements Runnable{
	Cinema cinema;
	List<Integer> num;
	
	public Customer(Cinema cinema, List<Integer> num) {
		super();
		this.cinema = cinema;
		this.num = num;
	}

	@Override
	public void run() {
		synchronized (cinema) {
			boolean flag=cinema.bookTicket(num);
			if(flag) {
				System.out.println("成功"+Thread.currentThread().getName()+"-《位置为："+num);
			}else {
				System.out.println("出票失败");
			}
		}
	}
}



class Cinema{
	List<Integer> available;//可用座位数
	String name;
	public Cinema(List<Integer> available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	//购票
	public boolean bookTicket(List<Integer> num){
		System.out.println("可用位置为："+available);
		List<Integer>copy=new ArrayList<Integer>();
		copy.addAll(available);
		
		copy.removeAll(num);
		
		if(available.size()-copy.size()!=num.size()) {
			return false;
		}
		available=copy;
		return true;
	}
	
}