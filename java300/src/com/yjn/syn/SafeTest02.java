package com.yjn.syn;
/**
 * 取钱 线程不安全
 * @author 82305
 *
 */
public class SafeTest02 {
	public static void main(String[] args) {
		SafeAccount account=new SafeAccount(100, "结婚礼金");
		SafeDrawing you=new SafeDrawing(account, 80, "you");
		SafeDrawing bf=new SafeDrawing(account, 90, "bf");
		you.start();
		bf.start();
	}
}
class SafeAccount{
	int money;
	String name;
	public SafeAccount(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}
	
}

class SafeDrawing extends Thread{
	SafeAccount account;//取钱的账户
	int drawingMoney;//取得钱数
	int drawingTotal;//取得总数
	
	
	public SafeDrawing(SafeAccount account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}


	@Override
	public void run() {
		
		test();
	}
//	public synchronized void test() {//锁的目标不对，锁定失败，应该锁定Account
	public void test() {
		if(account.money<=0)return;//提高性能
		synchronized (account) {//锁account
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
	
}
