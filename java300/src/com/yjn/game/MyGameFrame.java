package com.yjn.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * 飞机游戏的主窗口
 * @author 82305
 *
 */
public class MyGameFrame extends Frame{
	Image plane=GameUtil.getImage("images/plane.jpg");
	Image bg=GameUtil.getImage("images/bg.jpg");
	Plane p=new Plane(plane,250,250);
	Shell [] shells=new Shell[50];
	Date startTime=new Date();
	Date endTime;
	int period;
	
	@Override
	public void paint(Graphics g) {//自动被调用，g相当于一支画笔
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(bg, 0, 0, null);
		p.drawSelf(g);
		for(int i=0;i<shells.length;i++) {
			shells[i].draw(g);
			
			//飞机和炮弹的碰撞检测
			boolean peng=shells[i].getRect().intersects(p.getRect());
			
			if(peng) {
				p.live=false;
				endTime=new Date();
				period=(int)((endTime.getTime()-startTime.getTime())/1000);
				
			}
			if(!p.live) {
				Color color=g.getColor();
				g.setColor(Color.RED);
				Font font=new Font("宋体", Font.BOLD, 50);
				g.setFont(font);
				g.drawString("时间："+period+"秒",200,200);
				g.setColor(color);
			}
		}
//		Color c =g.getColor();
//		
//		g.setColor(Color.BLUE);
//		g.drawLine(100, 100, 300, 300);//重写父类方法，不加super等于舍弃
//		g.drawRect(100, 100, 300, 300);
//		g.fillRect(100, 100, 40, 40);//填充矩形
//		g.drawString("我是谁", 200, 200);
		
//		g.setColor(c);//g一直是一个对象，用完后要改回去
		
		
	}
	
	//内部类好处：可以直接使用外部类的属性
	//该线程反复重画窗口
	class PaintThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while(true) {
				repaint();//JFrame->Component中的方法   重画方法
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//键盘监听
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p.minusDirection(e);
		}
		
	}
	
	
	public void launchFrame() {//初始化窗口
		this.setTitle("yjn的游戏");
		this.setVisible(true);//设置窗口可见
		this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//设置窗口大小
		this.setLocation(300,300);//设置初始位置坐标，定位左上角
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});//设置窗口监听 窗口关掉游戏结束
		new PaintThread().start();//启动重画窗口的线程
		addKeyListener(new KeyMonitor());//增加键盘监听发
		
		for(int i=0;i<shells.length;i++) {
			shells[i]=new Shell();
		}
	}

	public static void main(String[] args) {
		MyGameFrame frame=new MyGameFrame();
		frame.launchFrame();
	}
	
	//双缓冲 解决页面闪烁
	private Image offScreenImage=null;
	public void update(Graphics g) {
		if(offScreenImage==null) {
			offScreenImage=this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		}
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
}
