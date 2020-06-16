package com.yjn.udp;
/**
 * 加入多线程   实现双向交流
 * @author 82305
 *
 */
public class TalkStudent {
	public static void main(String[] args) {
		new Thread(new TalkSend(8888,"localhost",9999)).start();
		new Thread(new TalkReceive(7777)).start();
	}
}
