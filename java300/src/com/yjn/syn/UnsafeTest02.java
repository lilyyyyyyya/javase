package com.yjn.syn;
/**
 * 取钱 线程不安全
 * @author 82305
 *
 */
public class UnsafeTest02 {
	public static void main(String[] args) {
		UnsafeAccount account=new UnsafeAccount(100, "结婚礼金");
		UnsafeDrawing you=new UnsafeDrawing(account, 80, "you");
		UnsafeDrawing bf=new UnsafeDrawing(account, 90, "bf");
		you.start();
		bf.start();
	}
}
class UnsafeAccount{
	int money;
	String name;
	public UnsafeAccount(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}
	
}

class UnsafeDrawing extends Thread{
	UnsafeAccount account;//取钱的账户
	int drawingMoney;//取得钱数
	int drawingTotal;//取得总数
	
	
	public UnsafeDrawing(UnsafeAccount account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}


	@Override
	public void run() {
		if(account.money-drawingMoney<0) return;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account.money-=drawingMoney;
		drawingTotal+=drawingMoney;
		System.out.println(this.getName()+"-->账户余额为"+account.money);
		System.out.println(this.getName()+"-->口袋的钱为"+drawingTotal);
		
	}
	
}
