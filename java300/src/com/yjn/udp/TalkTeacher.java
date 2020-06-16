package com.yjn.udp;
/**
 * 加入多线程   实现双向交流
 * @author 82305
 *
 */
public class TalkTeacher {
	public static void main(String[] args) {
		new Thread(new TalkReceive(9999)).start();
		new Thread(new TalkSend(5555,"localhost",7777)).start();
	}
}
