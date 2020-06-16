package com.yjn.syn;
/**
 * 协作模型 生产者消费者实现
 * 方式一：管程法
 * @author 82305
 *
 */
public class CoTest01 {
	public static void main(String[] args) {
		SynContainer container=new SynContainer();
		new Productor(container).start();
		new Consumer(container).start();
	}
}
//生产者
class Productor extends Thread{
	SynContainer sc;
	
	public Productor(SynContainer sc) {
		super();
		this.sc = sc;
	}

	@Override
	public void run() {
		//生产
		for(int i=0;i<100;i++) {
			System.out.println("生产"+i);
			sc.push(new Mantou(i));
		}
	}
	
}
//消费者
class Consumer extends Thread{
	SynContainer sc;
	
	public Consumer(SynContainer sc) {
		super();
		this.sc = sc;
	}
	@Override
	public void run() {
		//消费
		for(int i=0;i<100;i++) {
			System.out.println("消费"+sc.pop().id);
		}
	}
	
}

//缓冲区
class SynContainer{
	Mantou [] mantous=new Mantou[10];
	int count=0;//计数器
	//存储
	public synchronized void push(Mantou mantou) {
		//何时能生产 容器存在空间
		if(count==mantous.length) {
			try {
				this.wait();//线程阻塞 消费者通知生产者解除阻塞
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		mantous[count]=mantou;
		count++;
		this.notifyAll();//生产了，唤醒消费者
	}
	//获取
	public synchronized Mantou pop() {
		if(count==0) {
			try {
				this.wait();//线程阻塞 生产者通知消费者解除阻塞
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		count--;
		Mantou mantou=mantous[count];
		
		this.notifyAll();//存在空间 唤醒数据
		
		return mantou;
	}
}
//数据-》馒头

class Mantou{
	int id;

	public Mantou(int id) {
		super();
		this.id = id;
	}
	
}