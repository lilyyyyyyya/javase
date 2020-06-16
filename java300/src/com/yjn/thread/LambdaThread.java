package com.yjn.thread;
/**
 * 推导lambda表达式 简化线程的使用（一次使用且简单）
 * @author 82305
 *
 */

public class LambdaThread{
	static class Test  implements Runnable{//静态内部类
		@Override
		public void run() {
			for(int i=0;i<20;i++) {
				System.out.println("一边听歌");
			}
		}
	}

	
	public static void main(String[] args) {
		//创建子类对象
//		new Thread(new Test()).start();
		
//		class Test2  implements Runnable{//局部内部类
//			@Override
//			public void run() {
//				for(int i=0;i<20;i++) {
//					System.out.println("一边听歌");
//				}
//			}
//		}
//		
//		new Thread(new Test2()).start();
		
		//匿名内部类  必须借助接口或父类
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<20;i++) {
					System.out.println("一边听歌");
				}
			}
		}).start();
		
		//jdk8简化 lambda,接口名删掉，方法名删掉，保证接口只有一个没有实现的方法 lambda推导时一定有类型
		new Thread(()-> {
				for(int i=0;i<20;i++) {
					System.out.println("一边听歌");
				}
		}).start();
		
		new Thread(()->System.out.println("111"));
		
	}
}
