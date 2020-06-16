package com.yjn.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{
	int speed=3;
	boolean left,right,up,down;//定义飞机方向
	boolean live=true;
	@Override
	public void drawSelf(Graphics g) {
		// TODO Auto-generated method stub
		
		if(live) {
			super.drawSelf(g);
			if(left) {
				x-=speed;
			}
			if(right) {
				x+=speed;
			}
			if(up) {
				y-=speed;
			}
			if(down) {
				y+=speed;
			}
		}
		
	}
	public Plane () {
		
	}
	public Plane(Image image,double x,double y) {
		this.image=image;
		this.x=x;
		this.y=y;
		this.speed=3;
		this.height=image.getWidth(null);
		this.width=image.getHeight(null);
	 
	}
	//按下键盘，增加方向
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left=true;
			break;
		case KeyEvent.VK_UP:
			up=true;
			break;
		case KeyEvent.VK_RIGHT:
			right=true;
			break;
		case KeyEvent.VK_DOWN:
			down=true;
			break;
		default:
			break;
		}
	}
	public void minusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left=false;
			break;
		case KeyEvent.VK_UP:
			up=false;
			break;
		case KeyEvent.VK_RIGHT:
			right=false;
			break;
		case KeyEvent.VK_DOWN:
			down=false;
			break;
		default:
			break;
		}
	}
}
