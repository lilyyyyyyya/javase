package com.yjn.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 炮弹类
 * @author 82305
 *
 */
public class Shell extends GameObject{
	double degree;
	public Shell() {
		x=200;
		y=200;
		height=10;
		width=10;
		speed=3;
		degree=Math.random()*Math.PI*2;//0到2Π的随机数
	}
	public void draw(Graphics g) {
		Color color=g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int)x, (int)y, width, height);
		
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		if(x<0||x>Constant.GAME_WIDTH-width) {
			degree=Math.PI-degree;
		}
		if(y<30||y>Constant.GAME_HEIGHT-height) {
			degree=-degree;
		}
		
		g.setColor(color);
	}
}
