package com.yjn.thread;
/**
 * 静态代理
 * 1.真实角色
 * 2.代理角色
 * 实现同一个接口
 * @author 82305
 *
 */

public class StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();
		//new Thread(线程对象).start();
	}
}
interface Marry{
	void happyMarry();
}
//真实角色
class You implements Marry{
	@Override
	public void happyMarry() {
		System.out.println("我和任豪结婚了！！！！");
	}
}
//代理角色，婚庆公司不结婚
class WeddingCompany implements Marry{
	//真实角色
	private Marry target;
	public WeddingCompany(Marry target) {
		this.target=target;
	}
	@Override
	public void happyMarry() {
		ready();
		this.target.happyMarry();
		after();

	}
	
	private void ready() {
		System.out.println("布置婚房");
	}
    private void after() {
		System.out.println("闹洞房");
	}
}